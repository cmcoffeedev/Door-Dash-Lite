package com.dd.doordashlite.api

import com.dd.doordashlite.data.DoorDashStore
import com.dd.doordashlite.domain.Store
import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("num_results")
    val numOfResults: Int,
    @SerializedName("is_first_time_user")
    val isFirstTimeUser: Boolean,
    @SerializedName("sort_order")
    val sortOrder: String,
    @SerializedName("next_offset")
    val nextOffset: Int,
    @SerializedName("show_list_as_pickup")
    val showListAsPickup: Boolean,
    @SerializedName("stores")
    val stores: List<DoorDashStore>,
)

fun StoreResponse.asDomainModel(): List<Store> {
    return stores.map {
        Store(
            isConsumerSubscriptionEligible = it.isConsumerSubscriptionEligible,
            promotionDeliveryFee = it.promotionDeliveryFee,
            deliveryFee = it.deliveryFee,
            deliveryFeeMonetaryFields = it.deliveryFeeMonetaryFields,
            numOfRatings = it.numOfRatings,
            extraSosDeliveryFeeMonetaryFields = it.extraSosDeliveryFeeMonetaryFields,
            avgRating = it.avgRating,
            location = it.location,
            status = it.status,
            displayDeliveryFee = it.displayDeliveryFee,
            description = it.description,
            businessId = it.businessId,
            extraSosDeliveryFee = it.extraSosDeliveryFee,
            coverImgUrl = it.coverImgUrl,
            headerImgUrl = it.headerImgUrl,
            priceRange = it.priceRange,
            name = it.name,
            isNewlyAdded = it.isNewlyAdded,
            url = it.url,
            nextCloseTime = it.nextCloseTime,
            nextOpenTime = it.nextOpenTime,
            serviceRate = it.serviceRate,
            distanceFromConsumer = it.distanceFromConsumer,
            menus = it.menus,
            merchantPromotions = it.merchantPromotions,
            id = it.id)
    }
}


