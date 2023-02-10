package com.fs.module.category.product.ui

import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.module.category.product.data.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel : BaseViewModel() {

    val productDetailRepository : ProductDetailRepository by lazy {
        ProductDetailRepository()
    }
    fun getProductMessage(){
         viewModelScope.launch {
             productDetailRepository
         }
    }
}