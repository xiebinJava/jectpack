package com.fs.libbase

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


open class BaseApplication : Application() {


    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }
}
