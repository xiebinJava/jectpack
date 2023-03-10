package com.fs.module.home.module

import android.app.AppComponentFactory
import com.fs.libnet.BaseHttpClient
import com.fs.libnet.HttpClient.retrofit
import com.fs.libnet.HttpClient.retrofit1
import com.fs.module.home.HomeApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {





    @Provides
    @Singleton
    fun provideHomeApi(): HomeApiService {
        return Retrofit.Builder()
            .baseUrl("https://test-platform.whgxwl.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}