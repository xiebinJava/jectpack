package com.fs.libbase

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libbase.BuildConfig

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}
