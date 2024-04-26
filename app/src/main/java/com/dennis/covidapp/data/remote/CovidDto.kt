package com.dennis.covidapp.data.remote
import com.squareup.moshi.Json


data class CovidDto (

  @field:Json(name = "data" ) var covidData : CovidDataDto? = CovidDataDto()

)