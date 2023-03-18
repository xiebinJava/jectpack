package com.fs.libbase.netbase.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val netDispatcher: NetDispatcher)


enum class NetDispatcher {
    IO,
}