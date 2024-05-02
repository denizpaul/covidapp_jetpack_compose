package com.dennis.covidapp.presentation

sealed class HomeScreenEvents {
    object LoadGlobalCovidInfo : HomeScreenEvents()
    data class LoadRegionSpecificCovidInfo(val region: String) : HomeScreenEvents()
}