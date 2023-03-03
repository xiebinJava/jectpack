package com.fs.libutils.utils

import FsCache
import android.R
import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.google.gson.stream.JsonWriter
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
import java.io.OutputStreamWriter

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

    fun getLocalJson(context: Context, localFile: String): String {
        return try {
            val inputStream: InputStream = context.assets.open(localFile)
            val json = inputStream.bufferedReader().use { it.readText() }
            JSONObject(json).toString()
        } catch (e: IOException) {
            ""
        }
    }

    fun saveLocalJson(jsonString: String, key: String): Boolean {

        return FsCache.put(key,jsonString)
    }


}