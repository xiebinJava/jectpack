package com.fs.libnet.net

import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

interface HttpCallBack<Result> : ICallBack {

    override fun onSuccess(result: String) {
        val analysisClass = analysisClass(this)
        val fromJson = Gson().fromJson(result, analysisClass)
        onSuccess(fromJson as Result)
    }



    override fun onFailure(e: String) {
    }


    abstract fun onSuccess(result: Result?)


    fun analysisClass(any: Any): Class<Any> {
        val genericSuperclass : Type = any.javaClass.genericSuperclass
        if (genericSuperclass is ParameterizedType){
            val parameterizedType = genericSuperclass as ParameterizedType
            val actualTypeArguments  = parameterizedType.actualTypeArguments
            return actualTypeArguments[0] as Class<Any>
        }else{
            return Any::class.java
        }


    }


}