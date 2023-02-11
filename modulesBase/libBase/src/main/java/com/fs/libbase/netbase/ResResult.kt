package com.fs.libbase.netbase

import java.lang.Exception

/**
 * @author ace
 * @createDate 2021/5/25
 * @explain
 * api 返回结果封装
 */
sealed class ResResult<out T : Any> {
    data class Success<T : Any>(val data: T, val msg: String? = null) : ResResult<T>()
    data class Failure(val exception: Exception) : ResResult<Nothing>()
    data class Error(val exception: Exception) : ResResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Failure -> "Failure[exception=$exception]"
        }
    }


}