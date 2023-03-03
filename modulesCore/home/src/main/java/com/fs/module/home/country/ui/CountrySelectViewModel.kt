package com.fs.module.home.country.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.libbase.netbase.DataResult
import com.fs.libutils.constants.Constant
import com.fs.module.home.country.data.CountryModel
import com.fs.module.home.country.data.CountrySelectRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountrySelectViewModel @Inject constructor(
    private val countrySelectRepository: CountrySelectRepositoryImpl,
) : BaseViewModel() {


    var state by mutableStateOf(CountryState())
        private set

    var selectArea by mutableStateOf(0)

    fun getCountryInfo(localPath: String) {

        viewModelScope.launch {
            state = state.copy(
                loadingState = true
            )


            when (val localCountryInfo = countrySelectRepository.getLocalCountryInfo(localPath)) {
                is DataResult.Success -> {
                    state = state.copy(
                        countryInfo = localCountryInfo.data,
                        loadingState = false
                    )
                }
                is DataResult.Error -> {
                    state = state.copy(
                        loadingState = false
                    )
                }
            }
        }

    }

    fun setLeftBg(index: Int) {
        viewModelScope.launch {
            val list = state.countryInfo?.list!!
            for (countryInfo in list) {
                countryInfo.isChose = false
            }
            list[index].isChose = true
            state = state.copy(
                countryInfo = state.countryInfo
            )
        }

    }


    fun getRemoteCountryJson() {
        viewModelScope.launch {
            val remoteCountryInfo =
                countrySelectRepository.getRemoteCountryInfo(Constant.COUNTRY_JSON)

        }
    }


}

