package com.dennis.covidapp.domain.repository

import com.dennis.covidapp.domain.util.Resource
import com.dennis.covidapp.domain.covid.CovidInfo

interface CovidRepository {
    suspend fun getGlobalStatistics(): Resource<CovidInfo>
    suspend fun getRegionSpecificReports(region: String): Resource<CovidInfo>
}