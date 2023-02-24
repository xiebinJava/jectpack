package com.fs.module.category.product.ui

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvvmbase.BaseActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.fs.libbase.mvcbase.BaseComposeActivity

@Route(path = RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY)
@AndroidEntryPoint
class ProductDetailActivity : BaseComposeActivity() {

    private val productDetailViewModel by viewModels<ProductDetailViewModel>()
    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 请求权限示例
         *
         */
//        permissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestMultiplePermissions()
//        ) {
//            productDetailViewModel.getProductMessage()
//        }
//        permissionLauncher.launch(arrayOf(
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
//        ))

        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                if (it) {
                    productDetailViewModel.getProductMessage()
                } else {
                    Log.e("xiebin", "请求失败$it")
                }

            }

        setContent {
            Column {
                Button(onClick = { getData() }) {
                    Text(text = "点击进行网络请求")
                }
                val dataInfo = productDetailViewModel.state.dataInfo
                LazyColumn {
                    dataInfo?.let { index ->
                        items(index.size - 1) {
                            Column(
                                modifier = Modifier.padding(
                                    start = 0.dp,
                                    top = 5.dp,
                                    end = 0.dp,
                                    bottom = 0.dp
                                )
                            ) {
                                Text(
                                    text = dataInfo.datas[it].title,
                                    fontStyle = FontStyle(1),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = dataInfo.datas[it].author,
                                    fontSize = 15.sp,
                                    color = Color.Blue
                                )
                            }

                        }
                    }
                }


            }

        }

    }


    private fun getData() {
        productDetailViewModel.getProductMessage()
    }


    private fun initViews() {
        when {
            ContextCompat.checkSelfPermission(
                this@ProductDetailActivity,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                Log.e("xiebin", "请求成功")
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                Log.e("xiebin", "需要去设置页面")
            }
            else -> {
                permissionLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        }


    }


}