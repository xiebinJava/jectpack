package com.fs.module.home.country.ui

import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.module.home.country.domin.CountrySelectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountrySelectViewModel @Inject constructor(
    private val countrySelectRepository: CountrySelectRepository
) : BaseViewModel() {




}