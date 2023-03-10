package com.fs.module.home.mvpdemo.presenter

import com.fs.libbase.mvpbase.BasePresenter
import com.fs.libbase.mvpbase.BaseView
import com.fs.module.home.mvpdemo.model.LoginBean
import com.fs.module.home.mvpdemo.model.OnSignUpListener
import com.fs.module.home.mvpdemo.model.SignUpModel
import com.fs.module.home.mvpdemo.view.SignUpView
import javax.inject.Inject




class SignUpPresenter<T : SignUpView> @Inject constructor(private val signUpModel: SignUpModel) :
    BasePresenter<SignUpView>() {

    /**
     * 需要拿到view层的引用 和 model 层的引用
     */

    lateinit var  view : T


    /**
     * 业务逻辑
     */

    fun signUp() {
        signUpModel.signUp(object : OnSignUpListener {
            override fun onSuccess(loginBean: LoginBean) {
                view = myView!! as T
                view.showSignUpMsg(loginBean)
            }

            override fun onError(e: String) {

            }


        })

    }

}