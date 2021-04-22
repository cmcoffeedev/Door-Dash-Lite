package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashBusiness(
    @SerializedName("business_vertical")
    val businessVertical: DoorDashBusinessVertical,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)