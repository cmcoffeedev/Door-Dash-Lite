package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashStatus(
    @SerializedName("unavailable_reason")
    val unavailableReason: String,
    @SerializedName("pickup_available")
    val pickupAvailable: Boolean,
    @SerializedName("asap_available")
    val asapAvailable: Boolean,
    @SerializedName("scheduled_available")
    val scheduledAvailable: Boolean,
    @SerializedName("asap_minutes_range")
    val asapMinutesRange: List<Int>,
)
