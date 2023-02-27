package com.fs.module.category.login.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libbase.mvvmbase.BaseActivity
import com.fs.libutils.constants.RoutConstant.Activity.PRODUCT_LOGIN
import com.fs.module.category.R
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@AndroidEntryPoint
@Route(path = PRODUCT_LOGIN)
class LoginActivity : BaseComposeActivity() {

    private var loginMsg: TextView? = null
    private var progressBar: ProgressBar? = null
    private val loginViewModel by viewModels<LoginViewModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //当视图进入Resumed的时候，进行订阅state
        lifecycleScope.launchWhenResumed {
            loginViewModel.loginState.collect { viewState ->
                processViewState(viewState)
            }
        }

        val emailInput = findViewById<TextInputEditText>(R.id.email_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)
        val signInButton = findViewById<Button>(R.id.sign_in_button)
        progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        loginMsg = findViewById<TextView>(R.id.tv_login_msg)



        emailInput.doOnTextChanged { text, _, _, _ ->
            loginViewModel.emailChanged(text?.toString().orEmpty())
        }

        passwordInput.doOnTextChanged { text, _, _, _ ->
            loginViewModel.passwordChanged(text?.toString().orEmpty())
        }

        //获取个人积分
        loginViewModel.getUserInfo()

        //登录
        signInButton.setOnClickListener {
            loginViewModel.signInButtonClicked()
        }

        emailInput.setText("Brad.Xie")
        passwordInput.setText("625180058")



        lifecycleScope.launchWhenResumed {
            loginViewModel.loginState.collect { loginState ->
                loginMsg?.text = loginState.loginBean.toString()
            }
        }


        lifecycleScope.launchWhenResumed {
            loginViewModel.loginState.collect { loginState ->
                if (!loginState.userInfoBean?.rank.isNullOrEmpty()) {
                    Toast.makeText(
                        this@LoginActivity,
                        loginState.userInfoBean?.rank.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }


    }


    private fun processViewState(viewState: LoginViewState) {
        if (viewState.showProgressBar) {
            progressBar?.visibility = View.VISIBLE
        } else {
            progressBar?.visibility = View.GONE
        }
    }
}