package cn.com.sf.commonlib.cache

import android.content.Context
import android.os.Parcelable

/**
 * @ProjectName : Fiberstore
 * @Author : 作者
 * @Time : 2021/5/14 11:44 AM
 * @Description : 文件描述
 */
interface ICacheFunction {

    /**
     * 初始化
     */
    fun init(context: Context)

    fun put(key: String,  value: Any): Boolean

    fun <T : Parcelable> putParcelable(key: String, t: T?): Boolean

    fun getString(key: String,  default: String): String?

    fun getInt(key: String, default: Int): Int?

    fun getDouble(key: String, default: Double): Double?

    fun getFloat(key: String,  default: Float): Float?

    fun getLong(key: String,  default: Long): Long?

    fun getBoolean(key: String,  default: Boolean): Boolean?

    fun <T : Parcelable> getParcelable(key: String, tClass: Class<T>): T?

    fun removeKey(key: String)

    fun clearAll()

    fun contains(key: String):Boolean?

}