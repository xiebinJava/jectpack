package com.fs.jectpack

import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libbase.BaseApplication
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class APP  : BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }

    }
}