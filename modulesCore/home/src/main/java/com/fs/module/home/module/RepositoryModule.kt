package com.fs.module.home.module

import com.fs.module.home.country.data.CountrySelectRepositoryImpl
import com.fs.module.home.country.domin.CountrySelectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountryRepository(
        countrySelectRepositoryImpl: CountrySelectRepositoryImpl
    ): CountrySelectRepository
}