package com.fs.module.category.product.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fs.module.category.product.data.DataX

@SuppressLint("UnrememberedMutableState")
@Composable
fun Item(dataListInfo: List<DataX>, itemClick: (index: Int) -> Unit) {
    LazyColumn(content = {
        items(count = dataListInfo.size, itemContent = { index ->
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
                .clickable {
                    itemClick(index)
                }
                .background(color = Color.DarkGray)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    text = dataListInfo[index].title
                )
            }

        })
    })


}