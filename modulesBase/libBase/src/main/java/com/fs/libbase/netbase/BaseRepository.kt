package com.fs.libbase.netbase

import android.text.TextUtils
import android.util.Log
import com.fs.libutils.utils.CommonUtils
import com.google.gson.Gson
import retrofit2.HttpException

/**
 * @author ace
 * @createDate 2021/4/19
 * @explain
 *  接口请求封装
 */
open class BaseRepository {

    /**
     * 统一异常处理
     */
    suspend fun <T> safeApiCall(call: suspend () -> DataResult<T>): DataResult<T> {
        return try {
            call()
        } catch (e: Throwable) {
            e.printStackTrace()
            if (e is HttpException && e.response()?.errorBody() != null) {
                val errorBody = e.response()?.errorBody()
                val bodyMsg = errorBody?.string()
                if (bodyMsg != null && CommonUtils.getJSONType(bodyMsg)) {
                    val errorBean = Gson().fromJson(bodyMsg, ErrorBean::class.java)
                    if (errorBean != null)
                        return DataResult.Failure(
                            errorBean.code,
                            errorBean.message,
                            errorBean.errors
                        )
                }
            }
            DataResult.Error(e)
        }
    }

    /**
     * 统一响应处理
     */
    fun <T> executeResponse(
        response: CommonResponse<T>
    ): DataResult<T> {
        return when (response.code) {
            //wanandroid 的 api 没有code
            0 -> {
                DataResult.Success(response.data)
            }
            200 -> {
                DataResult.Success(response.data).apply {
                    pageResult?.successMeg = response.message
                }
            }
            else -> {//TODO 部分异常直接从异常抛出 需要手动解析
                DataResult.Failure(response.code, response.message, null)
            }
        }

    }


}