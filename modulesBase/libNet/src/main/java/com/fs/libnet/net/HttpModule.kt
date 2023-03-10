package com.fs.libnet.net

import android.app.AppComponentFactory
import com.fs.libnet.HttpClient.retrofit
import com.fs.libnet.HttpClient.retrofit1
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class HttpModule {

    @Binds
    @Singleton
    abstract fun bindOkHttp (otherProcessor: OtherProcessor):IHttpProcessor




}