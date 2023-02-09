package com.fs.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libUtils.constants.RoutConstant


@Route(path = RoutConstant.Activity.HOME_ACTIVITY)
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val findViewById = findViewById<TextView>(R.id.tv_home)
        findViewById.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.CATEGORY_ACTIVITY).navigation()
        }
    }
}