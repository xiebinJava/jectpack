import cn.com.sf.commonlib.cache.BaseCache
import cn.com.sf.commonlib.cache.MMKVCache


/**
 * @ProjectName : Fiberstore
 * @Author : 作者
 * @Time : 2021/5/14 11:53 AM
 * @Description : 文件描述
 */
object FsCache : BaseCache(MMKVCache())