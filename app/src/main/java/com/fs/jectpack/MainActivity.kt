package com.fs.jectpack


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

import com.fs.libbase.base.BaseActivity
import com.fs.libutils.constants.RoutConstant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       ARouter.getInstance().build(RoutConstant.Activity.HOME_ACTIVITY).navigation()


    }
}