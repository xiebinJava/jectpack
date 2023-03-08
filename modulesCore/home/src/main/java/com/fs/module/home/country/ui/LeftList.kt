package com.fs.module.home.country.ui

import android.util.Log
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
import androidx.compose.ui.unit.dp
import com.fs.module.home.country.data.CountryInfo
import com.fs.module.home.country.data.CountryModel


@Composable
fun leftColum(countryList: CountryModel, selectIndex: Int, clickAreaItem: (index: Int) -> Unit) {
    val size = countryList.list.size
    countryList.list[selectIndex].isChose = true
    LazyColumn(modifier = Modifier.width(150.dp)) {
        items(size) { index ->
            Box(
                modifier = Modifier
                    .height(35.dp)
                    .background(color = getBgColor(countryList.list[index]))
                    .fillMaxWidth()
                    .clickable {
                        clickAreaItem(index)

                    }) {
                Text(
                    text = countryList.list[index].areaName,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

        }
    }
}

fun getBgColor(country: CountryInfo): Color {
    return if (country.isChose) {
        Color.White
    } else {
        Color.Gray
    }
}
