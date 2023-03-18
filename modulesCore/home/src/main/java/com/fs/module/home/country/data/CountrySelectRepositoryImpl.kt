package com.fs.module.home.country.data

import FsCache
import android.content.Context
import android.util.Log
import com.fs.libbase.BaseApplication
import com.fs.libbase.netbase.BaseRepository
import com.fs.libbase.netbase.DataResult
import com.fs.libbase.netbase.di.Dispatcher
import com.fs.libbase.netbase.di.NetDispatcher
import com.fs.libnet.HttpClient
import com.fs.libutils.constants.Constant
import com.fs.libutils.utils.CommonUtils
import com.fs.module.home.HomeApiService
import com.fs.module.home.country.domin.CountrySelectRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountrySelectRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService,
    @Dispatcher(NetDispatcher.IO) private val ioDispatcher: CoroutineDispatcher,
) : CountrySelectRepository, BaseRepository() {

//    private val homeApiService: HomeApiService by lazy {
//        HttpClient.getFsTestService()
//    }

    override suspend fun getLocalCountryInfo(localPath: String): DataResult<CountryModel> =
        withContext(ioDispatcher) {
            // 将耗时操作移动到 IO 线程中
            return@withContext try {
                val localJson = CommonUtils.getLocalJson(BaseApplication.context, localPath)
                val jsonString = FsCache.getString(Constant.COUNTRY_JSON, localJson)
                val fromJson = Gson().fromJson(jsonString, CountryModel::class.java)
                DataResult.Success(fromJson)
            } catch (e: IOException) {
                DataResult.Error(-1, "解析失败", null)
            }


        }

    override suspend fun getRemoteCountryInfo(key: String): Boolean {

        val userInfo = homeApiService.getCountryInfo()
        val data = userInfo.data
        val toJson = Gson().toJson(data)
        return CommonUtils.saveLocalJson(toJson, key)
    }


}