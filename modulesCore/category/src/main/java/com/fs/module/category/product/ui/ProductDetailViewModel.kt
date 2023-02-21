package com.fs.module.category.product.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.libbase.netbase.DataResult
import com.fs.module.category.product.data.ProductDetailRepository
import com.fs.module.category.product.domain.FormatDataProductCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailRepository: ProductDetailRepository,
    private val formatDataProductCase: FormatDataProductCase
) :
    BaseViewModel() {


    fun getProductMessage() {
        viewModelScope.launch {
            val detail = productDetailRepository.getDetail()
            when (detail) {
                is DataResult.Success -> {
                    Log.e("xiebin", detail.data?.curPage.toString())
                }
                is DataResult.Error -> {
                    Log.e("xiebin", "aaaa")
                }
                is DataResult.Failure -> {
                    Log.e("xiebin", "bbbb")
                }
                is DataResult.Loading -> {
                    Log.e("xiebin", "cccc")
                }
                else -> {

                }
            }
        }
    }
}