package com.fs.module.home.mvpdemo.model

import com.fs.libnet.net.HttpCallBack
import com.fs.libnet.net.IHttpProcessor
import com.fs.module.home.mvpdemo.model.data.LoginBean
import javax.inject.Inject

class SignUpModelImpl @Inject constructor() : SignUpModel {


    @Inject
    lateinit var iHttpProcessor: IHttpProcessor

    override fun signUp(onSignUpListener: OnSignUpListener) {
        //从网络获取数据
        iHttpProcessor.post("", emptyMap(), object : HttpCallBack<LoginBean> {
            override fun onSuccess(result: LoginBean?) {
                if (result != null) {
                    onSignUpListener.onSuccess(result)
                }
            }

            override fun onFailure(e: String) {
                super.onFailure(e)
                onSignUpListener.onError(e)
            }


        })
    }



}