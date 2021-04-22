package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashDiscount(
   @SerializedName("description")
   val description: String,
   @SerializedName("source_type")
   val sourceType: String,
   @SerializedName("discount_type")
   val discountType: String,
   @SerializedName("amount")
   val amount: DoorDashAmount,
   @SerializedName("min_subtotal")
   val minSubtotal: DoorDashMinSubtotal,
)