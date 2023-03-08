package com.fs.module.home.country.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fs.module.home.country.data.Area


@Composable
fun rightColum(countryList: List<Area>?, selectIndex: Int, clickAreaItem: (index: Int) -> Unit) {
    val size = countryList?.size
    LazyColumn(modifier = Modifier.width(150.dp)) {
        items(size!!) { index ->
            Box(
                modifier = Modifier
                    .height(35.dp)
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .clickable {
                        clickAreaItem(index)

                    }) {
                Text(
                    text = "国家：" + countryList[index].countries_name + "货币:" + countryList[index].symbol,
                    modifier = Modifier.align(alignment = Alignment.Center),
                    style = TextStyle(fontSize = 10.sp)
                )
            }

        }
    }
}