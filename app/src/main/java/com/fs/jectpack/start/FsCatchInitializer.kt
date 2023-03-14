package com.fs.jectpack.start

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class FsCatchInitializer : Initializer<String> {
    override fun create(context: Context): String {
        //全局存储
        FsCache.init(context.applicationContext as Application)
        Log.e("xiebin","catch init 完成")

        return "catch init"
    }

    override fun dependencies():List<Class<out Initializer<*>>>  {
        return emptyList()
    }
}