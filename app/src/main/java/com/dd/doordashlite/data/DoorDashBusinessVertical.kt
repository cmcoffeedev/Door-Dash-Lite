package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashBusinessVertical(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)

