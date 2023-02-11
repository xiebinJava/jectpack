package com.fs.libutils.utils

import android.text.TextUtils

object CommonUtils {
    fun getJSONType(bodyMsg: String): Boolean {
        var str = bodyMsg
        var result = false
        if (!TextUtils.isEmpty(str)) {
            str = str.trim { it <= ' ' }
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true
            }
        }
        return result
    }

}