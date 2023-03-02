package com.fs.module.home.country.data

import android.content.Context
import com.fs.libbase.netbase.BaseRepository
import com.fs.libbase.netbase.DataResult
import com.fs.libutils.utils.CommonUtils
import com.fs.module.home.country.domin.CountrySelectRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountrySelectRepositoryImpl @Inject constructor() : CountrySelectRepository, BaseRepository() {



    override suspend fun getLocalCountryInfo(context: Context, localPath:String) : DataResult<CountryModel>{
        val localJson = CommonUtils.getLocalJson(context, localPath)
        return if (localJson.isNotEmpty()){
            val fromJson = Gson().fromJson(localJson, CountryModel::class.java)
            DataResult.Success(fromJson)
        }else{
            DataResult.Error(-1, "解析失败", null)
        }

    }


}