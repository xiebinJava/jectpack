package com.fs.module.category.product.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvvmbase.BaseActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.module.category.product.data.DataX
import kotlinx.coroutines.launch

@Route(path = RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY)
@AndroidEntryPoint
class ProductDetailActivity : BaseComposeActivity() {

    private val productDetailViewModel by viewModels<ProductDetailViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val productUiState = productDetailViewModel.state
            val dataListInfo = productUiState.items

            Box {
                Column {
                    Button(onClick = { getData() }) {
                        Text(text = "点击进行网络请求")
                    }

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp), onClick = {
                        productDetailViewModel.addItems()
                    }) {
                        Text(text = "add Item")
                    }

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp), onClick = {
                        productDetailViewModel.removeItems()
                    }) {
                        Text(text = "remove Item")
                    }
                    Item(dataListInfo) { index ->
                        clickItem(index)
                    }
                }

                if (productUiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
                } else {
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }

        }

    }


    private fun clickItem(index: Int) {
        productDetailViewModel.getItemChange(index)

    }


    private fun getData() {
        productDetailViewModel.getProductMessage()
    }


}