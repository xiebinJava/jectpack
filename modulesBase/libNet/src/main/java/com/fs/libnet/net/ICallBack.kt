package com.fs.libnet.net

interface ICallBack {

    fun onSuccess(result: String)
    fun onFailure(e: String)
}