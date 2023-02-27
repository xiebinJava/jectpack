package com.fs.module.category.login.ui

import androidx.lifecycle.viewModelScope
import com.fs.libbase.mvvmbase.BaseViewModel
import com.fs.libbase.netbase.DataResult
import com.fs.module.category.login.data.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    BaseViewModel() {

    private val _uiState = MutableStateFlow(LoginViewState())
    val loginState: StateFlow<LoginViewState> = _uiState.asStateFlow()


    fun emailChanged(newEmail: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(email = newEmail)
            }
        }
    }

    fun passwordChanged(newPassword: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(password = newPassword)
            }
        }
    }

    fun signInButtonClicked() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(showProgressBar = true)
            }
            when (val doLogin =
                loginRepository.doLogin(_uiState.value.email, _uiState.value.password)) {
                is DataResult.Success -> {
                    _uiState.update {
                        it.copy(
                            showProgressBar = false,
                            loginBean = doLogin.data
                        )
                    }
                }
                is DataResult.Error -> {
                    _uiState.update {
                        it.copy(
                            showProgressBar = false,
                            loginBean = null,
                            errorMsg = doLogin.message
                        )
                    }
                }
            }
        }
    }


    fun getUserInfo() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(showProgressBar = true)
            }
            val userInfo = loginRepository.getUserInfo()
            when (userInfo) {
                is DataResult.Success -> {
                    _uiState.update {
                        it.copy(showProgressBar = false,
                            userInfoBean = userInfo.data
                            )
                    }
                }
                is DataResult.Error -> {
                    _uiState.update {
                        it.copy(showProgressBar = false,
                            userInfoBean = null,
                            errorMsg = userInfo.message
                        )
                    }
                }
            }
        }
    }


}