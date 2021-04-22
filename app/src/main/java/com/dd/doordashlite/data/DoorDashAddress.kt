package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashAddress(
    @SerializedName("city")
    val city: String,
    @SerializedName("subpremise")
    val subpremise: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("printable_address")
    val printable_address: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("long")
    val long: Double,
    @SerializedName("shortname")
    val shortname: String,
    @SerializedName("zip_code")
    val zip_code: String,
)