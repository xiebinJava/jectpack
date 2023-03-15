package com.fs.jectpack


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkManagerInitializer
import androidx.work.WorkRequest
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.jectpack.start.WorkerInitializer
import com.fs.jectpack.work.DownLoadImageWorker

import com.fs.libutils.constants.RoutConstant
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       ARouter.getInstance().build(RoutConstant.Activity.HOME_ACTIVITY).navigation()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
//            val downLoadWorker: WorkRequest =
//                OneTimeWorkRequestBuilder<DownLoadImageWorker>()
//                    .build()
        }

        val build =
            PeriodicWorkRequestBuilder<DownLoadImageWorker>(15, TimeUnit.MINUTES).addTag("r1")
                .build()




        WorkManager
            .getInstance(this@MainActivity)
            .enqueue(build)
        Log.e("xiebin","onCreate")


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        Log.e("xiebin","onWindowFocusChanged $hasFocus")
    }
}