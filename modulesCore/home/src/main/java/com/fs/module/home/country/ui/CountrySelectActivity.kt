package com.fs.module.home.country.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libutils.constants.RoutConstant
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
@Route(path = RoutConstant.Activity.HOME_COUNTRY_SELECT)
class CountrySelectActivity : BaseComposeActivity() {

    private val countryViewModel by viewModels<CountrySelectViewModel>()


    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadLocalJson()


        setContent {

            Box {
                Column {
                    Button(onClick = { changeLocalJson()}) {
                        Text(text = "更改本地json文件")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        val countryList = countryViewModel.state.countryInfo

                        if (countryList != null) {
                            leftColum(
                                countryList,
                                countryViewModel.selectArea,
                                clickAreaItem = { index ->
                                    countryViewModel.selectArea = index
                                    countryViewModel.setLeftBg(index)
                                })

                            VerticalPager(
                                state = PagerState(
                                    countryList.list.size,
                                    countryViewModel.selectArea,
                                    0f,
                                    1,
                                    false
                                ), modifier = Modifier.fillMaxWidth()
                            ) { pageIndex ->
                                Box(modifier = Modifier.fillMaxHeight()) {
                                    rightColum(
                                        countryList.list[pageIndex].areaList,
                                        countryViewModel.selectArea,
                                        clickAreaItem = { index ->
                                            Toast.makeText(
                                                this@CountrySelectActivity,
                                                "国际： $ countryViewModel.selectArea  货币： $index",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        })
                                }

                            }
                        }




                    }
                }

            }


        }
    }


    private fun loadLocalJson(){
        lifecycleScope.launch {
            countryViewModel.getCountryInfo("country.json")
        }
    }

    private fun changeLocalJson() {
        lifecycleScope.launch {
            countryViewModel.getRemoteCountryJson()
        }

    }


}