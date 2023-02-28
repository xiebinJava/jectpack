package com.fs.module.category.login.ui

import androidx.compose.runtime.toMutableStateList
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
    var listData: List<String> = emptyList(),
    var errorMsg: String? = null,
) : State{

    private val _list: MutableList<String> = listData.toMutableStateList()
    val messages: List<String> = _list

    fun addMessage(msg: String) {
        _list.add( msg) // Add to the beginning of the list
    }

}