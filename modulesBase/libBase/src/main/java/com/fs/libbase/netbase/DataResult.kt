package com.fs.libbase.netbase

/**
 * @author ace
 * @createDate 2021/8/19
 * @explain
 *  数据结果统一封装
 */
sealed class DataResult<out T> {
    /**
     * 请求成功
     */
    data class Success<T>(val data: T?) : DataResult<T>()

    /**
     *  业务错误
     */
    data class Error(val code: Int?, val message: String?, val errors: Any?) :
        DataResult<Nothing>()






}



