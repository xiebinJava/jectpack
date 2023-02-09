package cn.com.sf.commonlib.cache

import cn.com.sf.commonlib.utils.ACache
import com.blankj.utilcode.util.Utils
import com.google.gson.Gson

/**
 * @author ace
 * @createDate 2021/10/25
 * @explain
 *  使用ACache
 *  专用界面第一次加载
 *  区分Okhttp 默认缓存
 */
object NetworkCache {

    const val SAVE_TIME = 60 * 60 * 24 * 7

    /**
     * 通过key获取缓存数据
     */
    inline fun <reified T> getCacheJsonByKey(key: String): T? {
        val json = ACache.get(Utils.getApp()).getAsString(key)
        if (!json.isNullOrBlank()) {
            return Gson().fromJson(json, T::class.java)
        }
        return null
    }

    /**
     * 保存Json 到缓存
     */
    fun saveJsonToCache(key: String, json: String) {
        ACache.get(Utils.getApp()).put(key, json, SAVE_TIME)
    }
}