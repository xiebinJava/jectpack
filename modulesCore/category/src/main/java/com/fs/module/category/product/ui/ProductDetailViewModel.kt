package com.fs.module.category.product.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.libbase.netbase.DataResult
import com.fs.module.category.product.data.ProductDetailRepository
import com.fs.module.category.product.domain.FormatDataProductCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailRepository: ProductDetailRepository,
    private val formatDataProductCase: FormatDataProductCase
) :BaseViewModel() {

    var state by mutableStateOf(ProductState(emptyList()))
        private set


    fun getProductMessage() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (val detail = productDetailRepository.getDetail()) {
                is DataResult.Success -> {
                    state = state.copy(
                        isLoading = false,
                        dataList = detail.data?.datas!!,
                        error = null
                    )

                }
                is DataResult.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = detail.errors.toString()
                    )
                }
            }
        }
    }



    fun addItems(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            delay(2000)
            state.addItem(state.dataAdd)
            state = state.copy(
                isLoading = false,
                dataList = state.items
            )


        }
    }

    fun removeItems(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            delay(2000)
            state.removeItem(0)
            state = state.copy(
                isLoading = false,
                dataList = state.items
            )


        }
    }

    fun getItemChange(index: Int){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            delay(2000)
            state.dataList[index].title = "你点击我了一下哦"
            state = state.copy(
                isLoading = false,
                dataList = state.items
            )


        }
    }

}