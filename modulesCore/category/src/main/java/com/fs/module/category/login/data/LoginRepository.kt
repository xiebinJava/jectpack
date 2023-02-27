package com.fs.module.category.login.data

import com.fs.libbase.netbase.BaseRepository
import com.fs.libbase.netbase.DataResult
import com.fs.libnet.HttpClient
import com.fs.module.category.product.ProductApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor() : BaseRepository() {

    private val productApiService: ProductApiService by lazy {
        HttpClient.getService()
    }

    suspend fun doLogin(email: String, password: String) :DataResult<LoginBean> {
        return safeApiCall { executeResponse(productApiService.doLogin(email,password)) }
    }

    suspend fun getUserInfo() :DataResult<UserInfoBean> {
        return safeApiCall { executeResponse(productApiService.getUserInfo()) }
    }

}