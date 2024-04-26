package com.dennis.covidapp.presentation

import com.dennis.covidapp.domain.covid.CovidInfo

data class CovidDataState(
    val covidInfo: CovidInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
