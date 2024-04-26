package com.dennis.covidapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CovidApi {

    @GET("reports/total")
    suspend fun getGlobalStatistics(
    ): CovidDto


    @GET("reports/total")
    suspend fun getRegionSpecificReport(
        @Query("iso")
        country: String = "AUS"
    ): CovidDto
}