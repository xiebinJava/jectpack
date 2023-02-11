package com.fs.libbase.netbase

import com.fs.libutils.utils.CommonUtils
import com.google.gson.Gson
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException


open class BaseUseCase {

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
    suspend fun <T> executeResponse(
        response: CommonResponse<T>
    ): DataResult<T> {
        return coroutineScope {
            when (response.code) {
                200 -> {
                    DataResult.Success(response.data)
                }
                else -> {
                    DataResult.Failure(response.code, response.message, null)
                }
            }
        }
    }
}