package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class SingleDoorDashMenu(
    @SerializedName("open_hours")
    val openHours: List<List<DoorDashHours>>,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("is_catering")
    val isCatering: Boolean,
    @SerializedName("status")
    val status: String,
    @SerializedName("menu_version")
    val menuVersion: Int,
    @SerializedName("is_business_enabled")
    val isBusinessEnabled: Boolean,
    @SerializedName("status_type")
    val statusType: String,
)
