package com.fs.libnet

import FsCache
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import okhttp3.CookieJar
import okhttp3.Request
import okhttp3.Response


object HttpClient : BaseHttpClient(){

    //https://www.wanandroid.com/blog/show/2
    private const val SERVER_URL_RELEASE = "https://www.wanandroid.com"
    private const val SERVER_URL_TEST = "https://test-platform.whgxwl.com"



    override fun providerCommonRequestConfig(request: Request): Request {
        val addHeader = request.newBuilder()
            .addHeader("clientType", "Android")
        return addHeader
            .build()
    }

    override fun supportCookie(): CookieJar {

        return FsCookie()
    }


    override fun getNormalUrl(): String  = SERVER_URL_RELEASE

    override fun getTestUrl(): String = SERVER_URL_RELEASE

    override fun getCommunityUrl(): String  = SERVER_URL_TEST


}