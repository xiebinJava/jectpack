import cn.com.sf.commonlib.cache.ICacheFunction

/**
  * @author ace
  * @createDate 2021/5/14
  * @explain 方便实现类,委托代理
 */
abstract class BaseCache(cacheFunction: ICacheFunction) :ICacheFunction by cacheFunction