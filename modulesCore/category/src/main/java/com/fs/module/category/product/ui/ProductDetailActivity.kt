package com.fs.module.category.product.ui

import android.util.Log
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvvmbase.BaseActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@Route(path = RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY)
@AndroidEntryPoint
class ProductDetailActivity : BaseActivity(R.layout.activity_category) {

    private val productDetailViewModel by viewModels<ProductDetailViewModel>()

    override fun initViews() {
        val button = findViewById<Button>(R.id.bt_product)
        button.setOnClickListener {
            productDetailViewModel.getProductMessage()
        }

    }


}