package com.fs.module.category.product

import com.fs.libbase.netbase.CommonResponse
import com.fs.module.category.login.data.LoginBean
import com.fs.module.category.login.data.UserInfoBean
import com.fs.module.category.product.data.ProductBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApiService {
    @GET("/article/list/0/json")
    suspend fun getProductDetail(): CommonResponse<ProductBean>
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun doLogin(
        @Field("username")
        email: String,
        @Field("password")
        password: String,
    ): CommonResponse<LoginBean>

    @GET("/lg/coin/userinfo/json")
    suspend fun getUserInfo(): CommonResponse<UserInfoBean>


}