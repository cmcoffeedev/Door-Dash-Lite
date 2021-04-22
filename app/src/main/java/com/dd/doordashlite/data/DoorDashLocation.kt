package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashLocation(
    @SerializedName("lat")
    val lat: String = "",
    @SerializedName("long")
    val long: String = "",
)
