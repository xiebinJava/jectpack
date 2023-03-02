package com.fs.libutils.utils

import android.R
import android.content.Context
import android.text.TextUtils
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

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

    fun getLocalJson(context: Context, localFile: String) : String{
        return try {
            val inputStream: InputStream = context.assets.open(localFile)
            val json = inputStream.bufferedReader().use { it.readText() }
            JSONArray(json).toString()
        } catch (e: IOException) {
            ""
        }
    }


}