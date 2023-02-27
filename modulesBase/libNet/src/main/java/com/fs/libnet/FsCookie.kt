package com.fs.libnet

import FsCache
import android.util.Log
import com.fs.libutils.constants.Constant
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl


class FsCookie : CookieJar {
    private var cache: ArrayList<Cookie> = ArrayList()


    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        //过期的Cookie

        val invalidCookies =  ArrayList<Cookie>()
        //有效的Cookie
        val validCookies = ArrayList<Cookie>()

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
        FsCache.put(Constant.COOKIE,cache)
    }


}