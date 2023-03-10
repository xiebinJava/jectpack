package com.fs.module.home.mvpdemo.view

import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvpbase.BaseMVPActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.home.R
import com.fs.module.home.mvpdemo.model.data.LoginBean
import com.fs.module.home.mvpdemo.model.SignUpModel
import com.fs.module.home.mvpdemo.presenter.SignUpPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@Route(path = RoutConstant.Activity.HOME_Sign_Up)
class SignUpActivity : SignUpView, BaseMVPActivity<SignUpPresenter<SignUpView>, SignUpView>() {


    @Inject
    lateinit var signUpModel:SignUpModel



    override fun showSignUpMsg(loginBean: LoginBean) {
        Log.e("xievbin","注册成功")
    }

    override fun showErrorMsg(msg: String) {

    }

    override fun init() {
        presenter.signUp()
    }

    override fun createPresenter(): SignUpPresenter<SignUpView> {
        return SignUpPresenter(signUpModel)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

}