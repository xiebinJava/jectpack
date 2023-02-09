import android.content.Context
import android.os.Parcelable
import cn.com.sf.commonlib.cache.ICacheFunction
import com.tencent.mmkv.MMKV
import org.jetbrains.annotations.Nullable

/**
 * @ProjectName : Fiberstore
 * @Author : 作者
 * @Time : 2021/5/14 12:04 PM
 * @Description : 文件描述
 */
class MMKVCache : ICacheFunction {


    var mmkv: MMKV? = null

    /**
     * 需要在Application初始化
     */
    override fun init(context: Context) {
        MMKV.initialize(context)
        mmkv = MMKV.defaultMMKV()
    }

    /**
     *保存基本类型
     */
    override fun put(key: String, value: Any): Boolean {
        val result = when (value) {
            is String -> mmkv?.encode(key, value)
            is Float -> mmkv?.encode(key, value)
            is Boolean -> mmkv?.encode(key, value)
            is Int -> mmkv?.encode(key, value)
            is Long -> mmkv?.encode(key, value)
            is Double -> mmkv?.encode(key, value)
            else -> false
        }
        return result ?: false
    }

    /**
     * 保存序列化类型
     */
    override fun <T : Parcelable> putParcelable(key: String, t: T?): Boolean {
        if (t != null) {
            return mmkv?.encode(key, t) ?: false
        }
        return false
    }

    override fun getString(key: String, @Nullable default: String): String? {
        return mmkv?.decodeString(key, default)
    }

    override fun getInt(key: String, @Nullable default: Int): Int? {
        return mmkv?.decodeInt(key, default)
    }

    override fun getDouble(key: String, @Nullable default: Double): Double? {
        return mmkv?.decodeDouble(key, default)
    }

    override fun getFloat(key: String, @Nullable default: Float): Float? {
        return mmkv?.decodeFloat(key, default)
    }

    override fun getLong(key: String, @Nullable default: Long): Long? {
        return mmkv?.decodeLong(key, default)

    }

    override fun getBoolean(key: String, @Nullable default: Boolean): Boolean? {
        return mmkv?.decodeBool(key, default)
    }

    override fun <T : Parcelable> getParcelable(key: String, tClass: Class<T>): T? {
        return mmkv?.decodeParcelable(key, tClass)
    }

    override fun removeKey(key: String) {
        mmkv?.removeValueForKey(key)
    }

    override fun clearAll() {
        mmkv?.clearAll()
    }

    override fun contains(key: String): Boolean? {
        return mmkv?.containsKey(key)
    }


}