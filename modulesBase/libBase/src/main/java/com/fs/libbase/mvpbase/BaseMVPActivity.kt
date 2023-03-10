package com.fs.libbase.mvpbase

import android.os.Bundle
import com.fs.libbase.mvcbase.BaseComposeActivity

abstract class BaseMVPActivity<T : BasePresenter<V>, V : BaseView> : BaseComposeActivity(),
    BaseView {

    lateinit var presenter: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter.attachView(this as V)
        init()
    }

    abstract fun init()


    abstract fun createPresenter(): T


    override fun onDestroy() {
        super.onDestroy()
        presenter.deatchView()
    }
}