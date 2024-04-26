package com.dennis.covidapp.di
import com.dennis.covidapp.data.remote.CovidApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCovidApi(): CovidApi {
        return Retrofit.Builder()
            .baseUrl("https://covid-api.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

}