package com.dd.doordashlite.domain

import com.dd.doordashlite.data.DoorDashAddress
import com.dd.doordashlite.data.DoorDashBusiness
import com.dd.doordashlite.data.DoorDashDeliveryFeeDetails
import com.dd.doordashlite.data.DoorDashMerchantPromotion
import com.dd.doordashlite.data.SingleDoorDashMenu

data class StoreDetail(
    val phoneNumber: String,
    val yelpReviewCount: Int,
    val isConsumerSubscriptionEligible: Boolean,
    val offersDelivery: Boolean,
    val maxOrderSize: Int,
    val deliveryFee: Int,
    val maxCompositeScore: Int,
    val providesExternalCourierTracking: Boolean,
    val id: Int,
    val avgRating: Double,
    val tags: List<String>,
    val deliveryRadius: Int,
    val inflationRate: Double,
    val menus: List<SingleDoorDashMenu>,
    val showStoreMenuHeaderPhoto: Boolean,
    val compositeScore: Int,
    val fulfillsOwnDeliveries: Boolean,
    val offersPickup: Boolean,
    val numberOfRatings: Int,
    val statusType: String,
    val isOnlyCatering: String,
    val status: String,
    val deliveryFeeDetails: DoorDashDeliveryFeeDetails,
    val objectType: String,
    val description: String,
    val business: DoorDashBusiness,
    val yelpBizId: String,
    val asapTime: String?,
    val shouldShowStoreLogo: Boolean,
    val yelpRating: Double,
    val extraSosDeliveryFee: Double,
    val businessId: Int,
    val specialInstructionsMaxLength: Int,
    val coverImgUrl: String,
    val address: DoorDashAddress,
    val priceRange: Int,
    val slug: String,
    val showSuggestedItems: Boolean,
    val name: String,
    val isNewlyAdded: Boolean,
    val isGoodForGroupOrders: Boolean,
    val serviceRate: Double,
    val merchantPromotions: List<DoorDashMerchantPromotion>,
    val headerImgUrl: String,
){
    fun getMenuStringList():List<String>{
        return menus.map{ it.name }
    }
}



