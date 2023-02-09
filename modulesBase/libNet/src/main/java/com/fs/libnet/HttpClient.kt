package com.fs.libnet

import okhttp3.CookieJar
import okhttp3.Request

object HttpClient : BaseHttpClient(){

    private const val SERVER_URL_RELEASE = "https://www.fs.com/app/v1/"



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