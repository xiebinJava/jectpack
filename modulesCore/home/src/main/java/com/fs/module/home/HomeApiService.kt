package com.fs.module.home


import com.fs.libbase.netbase.CommonResponse
import com.fs.libbase.netbase.DataResult
import com.fs.module.home.country.data.CountryModel
import com.fs.module.home.country.data.UserInfoBean
import retrofit2.http.GET

interface HomeApiService {


    @GET("/app/v1/website/siteRelation")
    suspend fun getCountryInfo(): CommonResponse<CountryModel>


}