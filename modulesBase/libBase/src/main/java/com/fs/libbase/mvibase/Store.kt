package com.fs.libbase.mvibase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [Store]是屏幕的状态容器
 * @param[initialState]这是首次创建屏幕时的初始状态。
 *一个系统，用于获取当前状态和新动作，并输出更新UI
 *
 */

class Store<S : State>(initialState: S) {


//    private val _uiState = MutableStateFlow(initialState())
//    val uiState: StateFlow<initialState> = _uiState.asStateFlow()

//    private val _state = MutableStateFlow(initialState)
//    val state: StateFlow<S> = _state

    //获取到当前的State
//    private val currentState: S
//        get() = _state.value

//    suspend fun dispatch(action: A) {
//        _state.value = currentState
//    }


}