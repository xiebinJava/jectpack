package com.fs.module.home.mvpdemo.model

import com.fs.module.home.mvpdemo.model.data.LoginBean

interface OnSignUpListener {

    fun onSuccess(loginBean: LoginBean)
    fun onError(e: String)
}