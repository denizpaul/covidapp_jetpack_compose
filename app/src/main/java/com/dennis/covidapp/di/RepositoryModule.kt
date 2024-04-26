package com.dennis.covidapp.di

import com.dennis.covidapp.data.repository.CovidRepositoryImpl
import com.dennis.covidapp.domain.repository.CovidRepository
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
    abstract fun bindCovidRepository(
        covidRepositoryImpl: CovidRepositoryImpl
    ): CovidRepository
}