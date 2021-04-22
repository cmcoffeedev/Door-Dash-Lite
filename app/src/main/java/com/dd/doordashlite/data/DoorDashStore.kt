package com.dd.doordashlite.data

import com.google.gson.annotations.SerializedName

data class DoorDashStore(
    @SerializedName("is_consumer_subscription_eligible")
    val isConsumerSubscriptionEligible: Boolean,
    @SerializedName("promotion_delivery_fee")
    val promotionDeliveryFee: Int,
    @SerializedName("delivery_fee")
    val deliveryFee: Int,
    @SerializedName("delivery_fee_monetary_fields")
    val deliveryFeeMonetaryFields: DoorDashMonetaryFields,
    @SerializedName("num_ratings")
    val numOfRatings: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("extra_sos_delivery_fee_monetary_fields")
    val extraSosDeliveryFeeMonetaryFields: DoorDashMonetaryFields,
    @SerializedName("menus")
    val menus: List<DoorDashMenu>,
    @SerializedName("avg_rating")
    val avgRating: Double,
    @SerializedName("location")
    val location: DoorDashLocation,
    @SerializedName("status")
    val status: DoorDashStatus,
    @SerializedName("display_delivery_fee")
    val displayDeliveryFee: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("business_id")
    val businessId: Int,
    @SerializedName("extra_sos_delivery_fee")
    val extraSosDeliveryFee: Int,
    @SerializedName("cover_img_url")
    val coverImgUrl: String,
    @SerializedName("header_img_url")
    val headerImgUrl: String,
    @SerializedName("price_range")
    val priceRange: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("is_newly_added")
    val isNewlyAdded: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("next_close_time")
    val nextCloseTime: String,
    @SerializedName("next_open_time")
    val nextOpenTime: String,
    @SerializedName("service_rate")
    val serviceRate: Int,
    @SerializedName("distance_from_consumer")
    val distanceFromConsumer: Double,
    @SerializedName("merchant_promotions")
    val merchantPromotions: List<DoorDashMerchantPromotion>,
)

