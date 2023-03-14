package com.fs.jectpack.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownLoadImageWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext,workerParams) {

    override fun doWork(): Result {
        Log.e("xiebin", Thread.currentThread().name)
        return Result.success()
    }
}