package com.fs.module.home.ho_debug

import android.app.Application
import com.fs.libbase.BaseApplication
import dagger.hilt.android.HiltAndroidApp
//作为application的时候需要打开
//@HiltAndroidApp
class HomeAPP :BaseApplication(){
    override fun onCreate() {
        super.onCreate()
    }
}