package com.dennis.covidapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennis.covidapp.domain.repository.CovidRepository
import com.dennis.covidapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CovidViewModel @Inject constructor(
    private val repository: CovidRepository
): ViewModel() {

    var state by mutableStateOf(CovidDataState())
        private set

    var regionState by mutableStateOf(CovidDataState())
        private set

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.LoadGlobalCovidInfo -> {
                loadCovidInfo()
            }
            is HomeScreenEvents.LoadRegionSpecificCovidInfo -> {
                loadRegionSpecificInfo(event.region)
            }
        }
    }


    fun loadCovidInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = repository.getGlobalStatistics()) {
                is Resource.Success -> {
                    state = state.copy(
                        covidInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        covidInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    fun loadRegionSpecificInfo(region: String) {
        viewModelScope.launch {
            regionState = regionState.copy(
                isLoading = true,
                error = null
            )

            when(val regionResult = repository.getRegionSpecificReports(region)) {
                is Resource.Success -> {
                    regionState = regionState.copy(
                        covidInfo = regionResult.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    regionState = regionState.copy(
                        covidInfo = null,
                        isLoading = false,
                        error = regionResult.message
                    )
                }
            }
        }
    }
}