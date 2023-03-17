package com.fs.libutils.start

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter

class ARouterInitializer : Initializer<String> {
    //在create()方法中可以进行初始化操作
    override fun create(context: Context): String {
        ARouter.init(context.applicationContext as Application)
        Log.e("xiebin","arout init 完成")
        return "ARout init"
    }

    //dependencies()方法表示，当前的初始化是否还依赖于其他的Initializer，
    // 如果有的话，就在这里进行配置，App Startup会保证先初始化依赖的Initializer，
    // 然后才会初始化当前，这样就可以设置初始化顺序了
    override fun dependencies(): List<Class<out Initializer<*>>> {
       return emptyList()
    }
}