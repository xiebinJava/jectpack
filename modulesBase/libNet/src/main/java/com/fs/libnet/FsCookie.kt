package com.fs.libnet

import FsCache
import android.util.Log
import com.fs.libutils.constants.Constant
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import java.lang.reflect.Type


class FsCookie : CookieJar {
    private var cache: ArrayList<Cookie> = ArrayList()


    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        //过期的Cookie

        val invalidCookies =  ArrayList<Cookie>()
        //有效的Cookie
        val validCookies = ArrayList<Cookie>()
        val cookieString = FsCache.getString(Constant.COOKIE,"")

        try {
            //json转换为list
            val type: Type = object : TypeToken<ArrayList<Cookie?>?>() {}.type
            cache = Gson().fromJson<ArrayList<Cookie>>(cookieString,type)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        for (cookie in cache) {
            if (cookie.expiresAt < System.currentTimeMillis()) {
                //判断是否过期
                invalidCookies.add(cookie);
            } else if (cookie.matches(url)) {
                //匹配Cookie对应url
                validCookies.add(cookie);
            }
        }

        //缓存中移除过期的Cookie
        cache.removeAll(invalidCookies.toSet())

        //返回List<Cookie>让Request进行设置
        return validCookies

    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        //内存中缓存Cookie
        cache.addAll(cookies)
        val toJson = Gson().toJson(cache)
        FsCache.removeKey(Constant.COOKIE)
        val put = FsCache.put(Constant.COOKIE, toJson.toString())
    }


}