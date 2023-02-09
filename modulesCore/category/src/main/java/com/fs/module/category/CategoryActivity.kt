package com.fs.module.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libUtils.constants.RoutConstant


@Route(path = RoutConstant.Activity.CATEGORY_ACTIVITY)
class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }
}