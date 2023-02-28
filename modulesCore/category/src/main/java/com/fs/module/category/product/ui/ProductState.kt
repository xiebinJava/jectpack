package com.fs.module.category.product.ui

import androidx.compose.runtime.toMutableStateList
import com.fs.module.category.product.data.DataX

data class ProductState(
    val dataList: List<DataX>,
    val isLoading: Boolean = false,
    val error: String? = null,

    val dataAdd: DataX = DataX(
        false,
        "",
        1,
        "",
        false,
        502,
        "自助",
        false,
        13,
        "",
        "",
        "",
        true,
        "",
        25888,
        false,
        "https://juejin.cn/post/7204854015463997496",
        "1小时前",
        "1小时前",
        "",
        "",
        "",
        1677549728000,
        493,
        0,
        0,
        "",
        123,
        "sweetying",
        emptyList(),
        "本地新增的一条数据title",
        0,
        0,
        5405,
        1,
    ),
){

    private val _item: MutableList<DataX> = dataList.toMutableStateList()
    val items: List<DataX> = _item
    fun addItem(dataAdd: DataX){
        _item.add(0,dataAdd)
    }

    fun removeItem(index:Int){
        _item.removeAt(index)
    }

}