package com.dd.doordashlite.api

import com.dd.doordashlite.data.*
import com.dd.doordashlite.domain.StoreDetail
import com.google.gson.annotations.SerializedName

data class SingleStoreResponse(
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("yelp_review_count")
    val yelpReviewCount: Int,
    @SerializedName("is_consumer_subscription_eligible")
    val isConsumerSubscriptionEligible: Boolean,
    @SerializedName("offers_delivery")
    val offersDelivery: Boolean,
    @SerializedName("max_order_size")
    val maxOrderSize: Int,
    @SerializedName("delivery_fee")
    val deliveryFee: Int,
    @SerializedName("max_composite_score")
    val maxCompositeScore: Int,
    @SerializedName("provides_external_courier_tracking")
    val providesExternalCourierTracking: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("average_rating")
    val avgRating: Double,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("delivery_radius")
    val deliveryRadius: Int,
    @SerializedName("inflation_rate")
    val inflationRate: Double,
    @SerializedName("menus")
    val menus: List<SingleDoorDashMenu>,
    @SerializedName("show_store_menu_header_photo")
    val showStoreMenuHeaderPhoto: Boolean,
    @SerializedName("composite_score")
    val compositeScore: Int,
    @SerializedName("fulfills_own_deliveries")
    val fulfillsOwnDeliveries: Boolean,
    @SerializedName("offers_pickup")
    val offersPickup: Boolean,
    @SerializedName("number_of_ratings")
    val numberOfRatings: Int,
    @SerializedName("status_type")
    val statusType: String,
    @SerializedName("is_only_catering")
    val isOnlyCatering: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("delivery_fee_details")
    val deliveryFeeDetails: DoorDashDeliveryFeeDetails,
    @SerializedName("object_type")
    val objectType: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("business")
    val business: DoorDashBusiness,
    @SerializedName("yelp_biz_id")
    val yelpBizId: String,
    @SerializedName("asap_time")
    val asapTime: String?,
    @SerializedName("should_show_store_logo")
    val shouldShowStoreLogo: Boolean,
    @SerializedName("yelp_rating")
    val yelpRating: Double,
    @SerializedName("extra_sos_delivery_fee")
    val extraSosDeliveryFee: Double,
    @SerializedName("business_id")
    val businessId: Int,
    @SerializedName("special_instructions_max_length")
    val specialInstructionsMaxLength: Int,
    @SerializedName("cover_img_url")
    val coverImgUrl: String?,
    @SerializedName("address")
    val address: DoorDashAddress,
    @SerializedName("price_range")
    val priceRange: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("show_suggested_items")
    val showSuggestedItems: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("is_newly_added")
    val isNewlyAdded: Boolean,
    @SerializedName("is_good_for_group_orders")
    val isGoodForGroupOrders: Boolean,
    @SerializedName("service_rate")
    val serviceRate: Double,
    @SerializedName("merchant_promotions")
    val merchantPromotions: List<DoorDashMerchantPromotion>,
    @SerializedName("header_image_url")
    val headerImgUrl: String?,
)


fun SingleStoreResponse.asDomainModel(): StoreDetail {
    val coverUrl = coverImgUrl ?: ""
    val headerUrl = headerImgUrl ?: ""
    return StoreDetail(
        phoneNumber,
        yelpReviewCount,
        isConsumerSubscriptionEligible,
        offersDelivery,
        maxOrderSize,
        deliveryFee,
        maxCompositeScore,
        providesExternalCourierTracking,
        id,
        avgRating,
        tags,
        deliveryRadius,
        inflationRate,
        menus,
        showStoreMenuHeaderPhoto,
        compositeScore,
        fulfillsOwnDeliveries,
        offersPickup,
        numberOfRatings,
        statusType,
        isOnlyCatering,
        status,
        deliveryFeeDetails,
        objectType,
        description,
        business,
        yelpBizId,
        asapTime,
        shouldShowStoreLogo,
        yelpRating,
        extraSosDeliveryFee,
        businessId,
        specialInstructionsMaxLength,
        coverUrl,
        address,
        priceRange,
        slug,
        showSuggestedItems,
        name,
        isNewlyAdded,
        isGoodForGroupOrders,
        serviceRate,
        merchantPromotions,
        headerUrl,
    )
}

