package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashFinalFee(
   @SerializedName("display_string")
   val displayString: String,
   @SerializedName("unit_amount")
   val unitAmount: Int,
)
