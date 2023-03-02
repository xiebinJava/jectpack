package com.fs.libbase

import FsCache
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libbase.BuildConfig
import dagger.hilt.android.HiltAndroidApp


open class BaseApplication : Application() {


    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        //全局存储
        FsCache.init(this)
    }
}
