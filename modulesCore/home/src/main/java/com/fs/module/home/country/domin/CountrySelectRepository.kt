package com.fs.module.home.country.domin

import android.content.Context
import com.fs.libbase.netbase.DataResult
import com.fs.module.home.country.data.CountryModel

interface CountrySelectRepository {


    suspend fun getLocalCountryInfo(localPath: String): DataResult<CountryModel>

    suspend fun getRemoteCountryInfo(key: String): Boolean

}