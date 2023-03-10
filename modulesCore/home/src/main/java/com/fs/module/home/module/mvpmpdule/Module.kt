package com.fs.module.home.module.mvpmpdule

import com.fs.module.home.country.data.CountrySelectRepositoryImpl
import com.fs.module.home.country.domin.CountrySelectRepository
import com.fs.module.home.mvpdemo.model.SignUpModel
import com.fs.module.home.mvpdemo.model.SignUpModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class Module {

    @Binds
    @Singleton
    abstract fun bindSignUpModel(
        signUpModelImpl: SignUpModelImpl
    ): SignUpModel
}