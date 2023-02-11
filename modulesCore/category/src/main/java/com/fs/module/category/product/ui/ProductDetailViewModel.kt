package com.fs.module.category.product.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.libbase.netbase.DataResult
import com.fs.module.category.product.data.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel : BaseViewModel() {

    val productDetailRepository : ProductDetailRepository by lazy {
        ProductDetailRepository()
    }
    fun getProductMessage(){
         viewModelScope.launch {
             val detail = productDetailRepository.getDetail()
             when(detail){
                 is DataResult.Success -> {
                    Log.e("xiebin", detail.data?.curPage.toString())
                 }
                 is DataResult.Error ->{
                     Log.e("xiebin","aaaa")
                 }
                 is DataResult.Failure ->{
                     Log.e("xiebin","bbbb")
                 }
                 is DataResult.Loading ->{
                     Log.e("xiebin","cccc")
                 }
                 else ->{

                 }
             }
         }
    }
}