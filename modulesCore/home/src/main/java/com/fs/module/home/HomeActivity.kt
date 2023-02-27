package com.fs.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libutils.constants.RoutConstant


@Route(path = RoutConstant.Activity.HOME_ACTIVITY)
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val findViewById = findViewById<TextView>(R.id.tv_home)
        val btViewMVI = findViewById<Button>(R.id.bt_view_mvi)
        findViewById.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY).navigation()
        }
        btViewMVI.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.PRODUCT_LOGIN).navigation()
        }
    }
}