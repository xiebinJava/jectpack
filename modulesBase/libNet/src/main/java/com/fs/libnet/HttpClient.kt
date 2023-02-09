package com.fs.libnet

import okhttp3.CookieJar
import okhttp3.Request

object HttpClient : BaseHttpClient(){

    //https://www.wanandroid.com/blog/show/2
    private const val SERVER_URL_RELEASE = "https://www.wanandroid.com"



    override fun providerCommonRequestConfig(request: Request): Request {
        val addHeader = request.newBuilder()
            .addHeader("clientType", "Android")
        return addHeader
            .build()
    }

    override fun supportCookie(): CookieJar? =null

    override fun getNormalUrl(): String  = SERVER_URL_RELEASE

    override fun getTestUrl(): String = SERVER_URL_RELEASE

    override fun getCommunityUrl(): String  = SERVER_URL_RELEASE


}