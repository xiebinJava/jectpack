package com.fs.libnet

import android.annotation.SuppressLint
import android.text.TextUtils
import com.fs.libutils.constants.Constant

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

/**
 * @author ace
 * @createDate 2021/4/23
 * @explain
 *
 *  FS 网络请求基类
 *
 *  1.调试日志
 *  2.自定义BaseUrl
 *  3.支持缓存  离线读取本地,在线读取网络
 *  4.http支持
 *  5.本地cookie
 *  6.支持json打印
 *
 *
 */

abstract class BaseHttpClient() : IApiEnvironment {
    private var timeOut: Long = 60
    private var isDebug: Boolean = false

    companion object {
        val JSON: MediaType = "application/json".toMediaType()
    }

    private val client: OkHttpClient by lazy {

        OkHttpClient.Builder().apply {
            connectTimeout(timeOut, TimeUnit.SECONDS)
            readTimeout(timeOut, TimeUnit.SECONDS)
            writeTimeout(timeOut, TimeUnit.SECONDS)
            initHttps(this)
            //调试日志
            //通用请求头和请求参数支持
            addInterceptor { chain ->
                var request = chain.request()
                providerCommonRequestConfig(request)?.let {
                    request = it
                }
                val response = chain.proceed(request)
                handleCommonResponse(response)
                response
            }

            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(logging)
            }
            //支持Cookie
            supportCookie()?.let {
                cookieJar(it)
            }
        }.build()
    }

    /**
     * 处理通用的接口响应
     */
    @SuppressLint("NewApi")
    open fun handleCommonResponse(response: Response) {
        response.body?.apply {
            val source = source()
            source.request(Long.MAX_VALUE)
            val buffer = source.buffer
            val contentType = contentType()
            val charset: Charset = contentType?.charset(StandardCharsets.UTF_8) ?: StandardCharsets.UTF_8
            if (contentLength() != 0L) {
                val json = buffer.clone().readString(charset)
                ResponseCodeHandler.handleV1ApiResponse(json)
            }
        }
    }


    val retrofit: Retrofit by lazy {
        isDebug = FsCache.getBoolean(Constant.IS_DEBUG, false)!!
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(if (isDebug) getTestUrl() else getNormalUrl())
            .build()
    }


    val retrofit1: Retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(getCommunityUrl())
            .build()
    }


    inline fun <reified ApiService> getService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    inline fun <reified ApiService> getCommunity(): ApiService {
        return retrofit1.create(ApiService::class.java)
    }





    /**
     * 通用请求配置
     */
    abstract fun providerCommonRequestConfig(request: Request): Request?

    /**
     * 支持https
     */
    open fun initHttps(builder: OkHttpClient.Builder) {

    }

    /**
     * 支持Cookie
     */
    abstract fun supportCookie(): CookieJar?


}