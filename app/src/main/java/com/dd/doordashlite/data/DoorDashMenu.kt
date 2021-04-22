package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashMenu(
    @SerializedName("popular_items")
    val popularItems: List<DoorDashMenuItem>,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("is_catering")
    val isCatering: Boolean,
)
