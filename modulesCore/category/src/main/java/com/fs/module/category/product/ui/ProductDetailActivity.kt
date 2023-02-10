package com.fs.module.category.product.ui

import android.util.Log
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvvmbase.BaseActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.R

@Route(path = RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY)
class ProductDetailActivity : BaseActivity<ProductDetailViewModel>(R.layout.activity_category) {

    override fun providerViewModel(): ProductDetailViewModel {
        return ProductDetailViewModel()
    }

    override fun initViews() {
        val button = findViewById<Button>(R.id.bt_product)
        button.setOnClickListener {
            viewModel?.getProductMessage()
        }

    }


}