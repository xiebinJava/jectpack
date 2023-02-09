package com.fs.libnet

/**
 * @author ace
 * @createDate 2021/4/24
 * @explain
 *  环境
 */
interface IApiEnvironment {
    fun getNormalUrl(): String
    fun getTestUrl(): String
    fun getCommunityUrl(): String
}