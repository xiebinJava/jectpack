package com.fs.libbase.netbase

import com.google.gson.annotations.SerializedName

/**
 * @author ace
 * @createDate 2021/8/20
 * @explain  通用Response
 * @version v1
 *
 */
data class CommonResponse<T>(
    @SerializedName("code", alternate = ["status_code"])
    val code: Int,
    val `data`: T,
    val errors: List<Any>,
    val message: String,
    val status: String
) {
    fun isSuccess() = code == 200
}

