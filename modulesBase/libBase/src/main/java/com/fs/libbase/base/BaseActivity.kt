package com.fs.libbase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

abstract class BaseActivity<VM : BaseViewModel>(var layoutId: Int) : AppCompatActivity() {

     var viewModel: VM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        viewModel = buildViewModelByClass(getDefaultVMClass(), ::providerViewModelWithExtras)
        initViews()
    }


    private fun <T : ViewModel> buildViewModelByClass(
        vmClass: Class<T>,
        block: CreationExtras.() -> T
    ): T {
        return ViewModelProvider(
            this,
            viewModelFactory { addInitializer(vmClass.kotlin, block) })[vmClass]
    }

    private fun getDefaultVMClass(): Class<VM> {
        var curClass: Class<*> = this::class.java
        var parentType: Type?
        while (true) {
            parentType = curClass.genericSuperclass

            if (parentType is ParameterizedType) {
                val clazz = parentType.actualTypeArguments[0] as Class<*>
                if (ViewModel::class.java.isAssignableFrom(clazz))
                    return clazz as Class<VM>
            }

            curClass = curClass.superclass
        }
    }

    open fun providerViewModelWithExtras(creationExtras: CreationExtras): VM = providerViewModel()
        ?: throw IllegalArgumentException("providerViewModel() return not null")

    abstract fun providerViewModel(): VM?
    abstract fun initViews()
}