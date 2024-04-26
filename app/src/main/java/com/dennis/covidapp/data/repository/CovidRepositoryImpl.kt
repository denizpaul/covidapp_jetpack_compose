package com.dennis.covidapp.data.repository

import com.dennis.covidapp.data.mappers.toCovidInfo
import com.dennis.covidapp.data.remote.CovidApi
import com.dennis.covidapp.domain.repository.CovidRepository
import com.dennis.covidapp.domain.util.Resource
import com.dennis.covidapp.domain.covid.CovidInfo
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(
    private val api: CovidApi
): CovidRepository {

    override suspend fun getGlobalStatistics(): Resource<CovidInfo> {
        return try {
            Resource.Success(
                data = api.getGlobalStatistics(
                ).toCovidInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getRegionSpecificReports(region: String): Resource<CovidInfo> {
        return try {
            Resource.Success(
                data = api.getRegionSpecificReport(
                ).toCovidInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}