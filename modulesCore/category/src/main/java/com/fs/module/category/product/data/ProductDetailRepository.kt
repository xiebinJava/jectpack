package com.fs.module.category.product.data

import com.fs.libbase.netbase.BaseRepository
import com.fs.libbase.netbase.DataResult
import com.fs.libnet.HttpClient
import com.fs.module.category.ProductApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailRepository @Inject constructor() : BaseRepository() {


    private val productApiService: ProductApiService by lazy {
        HttpClient.getService()
    }


    suspend fun getDetail(): DataResult<ProductBean> {
        return safeApiCall { executeResponse(productApiService.getProductDetail()) }

    }


}