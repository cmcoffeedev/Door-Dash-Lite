package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashMenuItem(
    @SerializedName("price")
    val price: Int,
    @SerializedName("img_url")
    val imgUrl: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
)


