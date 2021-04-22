package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashMerchantPromotion(
    @SerializedName("category_new_store_customers_only")
    val categoryNewStoreCustomersOnly: Boolean,
    @SerializedName("minimum_subtotal_monetary_fields")
    val minimumSubtotalMonetaryFields: DoorDashMonetaryFields,
    @SerializedName("daypart_constraints")
    val dayPartConstraints: List<String>,
    @SerializedName("delivery_fee")
    val deliveryFee: Int,
    @SerializedName("delivery_fee_monetary_fields")
    val deliveryFeeMonetaryFields: DoorDashMonetaryFields,
    @SerializedName("minimum_subtotal")
    val minimumSubtotal: Int,
    @SerializedName("id")
    val id: Int,
)
