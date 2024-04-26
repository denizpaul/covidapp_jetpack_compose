package com.dennis.covidapp.data.remote
import com.squareup.moshi.Json


data class CovidDataDto (
  @field:Json(name = "date"           ) var date          : String? = null,
  @field:Json(name = "last_update"    ) var lastUpdate    : String? = null,
  @field:Json(name = "confirmed"      ) var confirmed     : Int?    = null,
  @field:Json(name = "confirmed_diff" ) var confirmedDiff : Int?    = null,
  @field:Json(name = "deaths"         ) var deaths        : Int?    = null,
  @field:Json(name = "deaths_diff"    ) var deathsDiff    : Int?    = null,
  @field:Json(name = "recovered"      ) var recovered     : Int?    = null,
  @field:Json(name = "recovered_diff" ) var recoveredDiff : Int?    = null,
  @field:Json(name = "active"         ) var active        : Int?    = null,
  @field:Json(name = "active_diff"    ) var activeDiff    : Int?    = null,
  @field:Json(name = "fatality_rate"  ) var fatalityRate  : Double? = null

)