package com.fauzan.myworkmanager

import com.squareup.moshi.Json

data class Main(
    @Json(name = "temp")
    val temperature: Double
)
