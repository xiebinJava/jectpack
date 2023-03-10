package com.fs.module.home.mvpdemo.model

interface OnSignUpListener {

    fun onSuccess(loginBean: LoginBean)
    fun onError(e: String)
}