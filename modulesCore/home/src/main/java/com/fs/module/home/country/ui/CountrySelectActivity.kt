package com.fs.module.home.country.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libutils.constants.RoutConstant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = RoutConstant.Activity.HOME_COUNTRY_SELECT)
class CountrySelectActivity : BaseComposeActivity() {

    val countryViewModel by viewModels<CountrySelectViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {


        }
    }


}