package com.dennis.covidapp.domain.covid


data class CovidData (
  val date          : String? = null,
  val lastUpdate    : String? = null,
  val confirmed     : Int? = null,
  val confirmedDiff : Int? = null,
  val deaths        : Int? = null,
  val deathsDiff    : Int? = null,
  val recovered     : Int? = null,
  val recoveredDiff : Int? = null,
  val active        : Int? = null,
  val activeDiff    : Int? = null,
  val fatalityRate  : Double? = null

)