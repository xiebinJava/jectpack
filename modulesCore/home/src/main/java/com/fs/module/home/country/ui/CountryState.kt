package com.fs.module.home.country.ui

import com.fs.libbase.mvibase.State
import com.fs.module.home.country.data.CountryModel

data class CountryState(
    val countryInfo: CountryModel? = null,
    val loadingState: Boolean = false,
    ) : State {

}
