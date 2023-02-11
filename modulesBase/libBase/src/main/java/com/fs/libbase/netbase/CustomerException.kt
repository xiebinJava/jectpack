package com.fs.libbase.netbase
import com.fs.libbase.R
import java.lang.Exception
import java.lang.RuntimeException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author ace
 * @createDate 2021/5/27
 * @explain
 * 服务器异常,业务异常处理
 */
class CustomerException(
    val code: Int,
    message: String?=null,
    val result: String?=null,
    cause: Throwable? = null
) :
    RuntimeException(message, cause) {


    companion object {

        /*********服务器类型错误**********/

        /**
         * 未知错误
         */
        const val UNKNOWN: Int = 1000

        /**
         * 网络错误
         */
        const val NETWORK_ERROR: Int = 1002

        /*********服务器类型错误**********/

        /*********业务类型**********/
        const val NOT_LOGIN: Int = 2

        /*********业务类型**********/


        /**
         * 处理服务器异常
         */
        fun handleResponseError(exception: Exception): CustomerException {

//            LogUtils.eTag("CustomerException","handleResponseError "+exception)
            var code =
                UNKNOWN
            var message = "Unknown exception"
            var result = "Fail"
            if (isCacheError(
                    exception
                ) || exception is UnknownHostException || exception is SocketTimeoutException || exception is ConnectException
            ) {
                code = NETWORK_ERROR
                message = "ConnectionError"
            }
            return CustomerException(
                code,
                message,
                result,
                exception
            )
        }

        /**
         * 处理非200业务异常
         * msg 可能不是String
         */
        fun handleResponseFailure(code: Int, msg: String?, result: String): CustomerException {
            return CustomerException(code, msg, result)
        }

        /**
         * 缓存失效
         */
        private fun isCacheError(error: Throwable?): Boolean {
            return error?.message?.contains("504") ?: false
        }
    }

    fun toFailureResult(): ResResult<Nothing> {
        return ResResult.Failure(this)
    }


    fun toErrorResult(): ResResult<Nothing> {
        return ResResult.Error(this)
    }

    fun interceptCodeResult() {
//        when(code){
//            NOT_LOGIN -> {
//                ActivityUtils.getTopActivity().finish()
//                RouterManager.startPage(RouterPath.PAGE_LOGIN)
//            }
//        }
    }


}