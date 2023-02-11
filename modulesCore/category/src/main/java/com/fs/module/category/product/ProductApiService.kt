package com.fs.module.category.product

import com.fs.libbase.netbase.CommonResponse
import com.fs.module.category.product.data.ProductBean
import retrofit2.http.GET

interface ProductApiService {
    @GET("/article/list/0/json")
    suspend fun getProductDetail(): CommonResponse<ProductBean>

}