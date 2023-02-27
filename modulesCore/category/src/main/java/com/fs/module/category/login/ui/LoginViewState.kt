package com.fs.module.category.login.ui

import com.fs.libbase.mvibase.State
import com.fs.module.category.login.data.LoginBean
import com.fs.module.category.login.data.UserInfoBean


data class LoginViewState(
    val email: String = "",
    val password: String = "",
    val showProgressBar: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    var loginBean: LoginBean? = null,
    var userInfoBean: UserInfoBean? = null,
    var errorMsg: String? = null,
) : State