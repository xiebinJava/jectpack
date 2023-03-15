package com.fs.jectpack.start

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager


class WorkerInitializer :Initializer<WorkManager>{
    override fun create(context: Context): WorkManager {
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        Log.e("xiebin","worker init 完成")
        return WorkManager.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {

        return emptyList()
    }

}