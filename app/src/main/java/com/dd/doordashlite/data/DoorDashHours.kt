package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashHours(
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("minute")
    val minute: Int

)
