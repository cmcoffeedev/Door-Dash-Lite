package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashMonetaryFields(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("display_string")
    val displayString: String,
    @SerializedName("unit_amount")
    val unitAmount: Int,
    @SerializedName("decimal_places")
    val decimalPlaces: Int,
)
