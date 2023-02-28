package com.fs.module.category.permission

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.R

@Route(path = RoutConstant.Activity.REQUEST_PERMISSION)
class PermissionActivity : BaseComposeActivity(){

    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                if (it) {
                    Log.e("xiebin", "请求成功$it")
                } else {
                    Log.e("xiebin", "请求失败$it")
                }
            }
        val request = findViewById<Button>(R.id.bt_request_permission)
        request.setOnClickListener {
            requestPermission()
        }


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
    }

    private fun requestPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this@PermissionActivity,
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