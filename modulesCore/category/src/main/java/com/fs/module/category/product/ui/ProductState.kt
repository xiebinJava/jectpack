package com.fs.module.category.product.ui

import com.fs.module.category.product.data.DataX
import com.fs.module.category.product.data.ProductBean

data class ProductState(
    val dataInfo: ProductBean? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)