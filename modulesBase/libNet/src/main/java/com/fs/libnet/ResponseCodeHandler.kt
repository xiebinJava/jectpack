package com.fs.libnet



import org.json.JSONObject

/**
 * @author ace
 * @createDate 2021/9/8
 * @explain
 *  响应码处理
 */
object ResponseCodeHandler {
    fun handleV1ApiResponse(response: String) {
        try {
//            LogUtils.json(LogUtils.I, response)
            val jsonObject = JSONObject(response)
            if (jsonObject.has("code")) {
                val code = jsonObject.getInt("code")
                handleV1ResponseCode(code)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handleV1ResponseCode(code: Int) {
        when (code) {
            401 -> {//Token 失效
//                EventBus.getDefault().post(LoginInvalidEvent.TokenUnauthorizedEvent())
            }
            else -> {
            }
        }

    }
}