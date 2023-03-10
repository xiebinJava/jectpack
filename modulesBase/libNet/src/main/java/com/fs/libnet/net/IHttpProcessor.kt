package com.fs.libnet.net

import androidx.annotation.Nullable
import java.util.Objects

interface IHttpProcessor {



    fun post(url: String, params: Map<String, Any>, callBack: ICallBack)

}