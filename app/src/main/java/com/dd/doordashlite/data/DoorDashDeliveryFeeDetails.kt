package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashDeliveryFeeDetails(
    @SerializedName("final_fee")
    val finalFee: DoorDashFinalFee,
)