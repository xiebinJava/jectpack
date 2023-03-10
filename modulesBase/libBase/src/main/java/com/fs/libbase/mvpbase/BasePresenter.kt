package com.fs.libbase.mvpbase

import java.lang.ref.WeakReference

open class BasePresenter<T : BaseView> {

    open  var myView: WeakReference<T>? = null

    fun attachView(view: T) {
        myView = WeakReference(view)

    }

    fun deatchView() {
        myView?.clear()
        myView = null
    }
}
