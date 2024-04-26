package com.dennis.covidapp.data.mappers

import com.dennis.covidapp.data.remote.CovidDataDto
import com.dennis.covidapp.data.remote.CovidDto
import com.dennis.covidapp.domain.covid.CovidData
import com.dennis.covidapp.domain.covid.CovidInfo

fun CovidDataDto.toCovidData(): CovidData {
    return CovidData(
        date = date,
        lastUpdate = lastUpdate,
        confirmed = confirmed,
        fatalityRate = fatalityRate,
        deaths = deaths
    )
}

fun CovidDto.toCovidInfo(): CovidInfo {
    val covidDataMap = covidData?.toCovidData()
    return CovidInfo(
        covidData = covidDataMap
    )
}