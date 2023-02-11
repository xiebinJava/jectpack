package com.fs.libbase.netbase

import java.util.ArrayList

/**
 * @author ace
 * @createDate 2021/8/19
 * @explain 分页拓展
 */
data class PageResult(var hasMore: Boolean=true){
    var successMeg:String = "" //接口成功返回message
    var typeItems = ArrayList<Any>()
    var inputParameter:Any = ""

}