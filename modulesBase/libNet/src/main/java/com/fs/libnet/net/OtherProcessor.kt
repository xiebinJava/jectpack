package com.fs.libnet.net

import javax.inject.Inject


class OtherProcessor @Inject constructor() : IHttpProcessor {


    override fun post(url: String, params: Map<String, Any>, callBack: ICallBack) {
        //网络请求框架 获取到网络请求回来的json
        val json: String = ""
        callBack.onSuccess(json)
    }
}