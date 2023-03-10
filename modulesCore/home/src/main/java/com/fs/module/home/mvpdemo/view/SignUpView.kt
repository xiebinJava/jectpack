package com.fs.module.home.mvpdemo.view

import com.fs.libbase.mvpbase.BaseView
import com.fs.module.home.mvpdemo.model.LoginBean
import javax.inject.Singleton

@Singleton
interface SignUpView : BaseView {

    fun showSignUpMsg(loginBean: LoginBean)
}