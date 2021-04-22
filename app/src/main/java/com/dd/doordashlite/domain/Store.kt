package com.dd.doordashlite.domain

import com.dd.doordashlite.data.*
import java.time.Instant
import java.util.Date


data class Store(
    val isConsumerSubscriptionEligible: Boolean,
    val promotionDeliveryFee: Int,
    val deliveryFee: Int,
    val deliveryFeeMonetaryFields: DoorDashMonetaryFields,
    val numOfRatings: Int,
    val id: Int,
    val extraSosDeliveryFeeMonetaryFields: DoorDashMonetaryFields,
    val menus: List<DoorDashMenu>,
    val avgRating: Double,
    val location: DoorDashLocation,
    val status: DoorDashStatus,
    val displayDeliveryFee: String,
    val description: String,
    val businessId: Int,
    val extraSosDeliveryFee: Int,
    val coverImgUrl: String,
    val headerImgUrl: String,
    val priceRange: Int,
    val name: String,
    val isNewlyAdded: Boolean,
    val url: String,
    val nextCloseTime: String,
    val nextOpenTime: String,
    val serviceRate: Int,
    val distanceFromConsumer: Double,
    val merchantPromotions: List<DoorDashMerchantPromotion>
){

    fun getShortDescription():String{
        val descriptionList =  description.split(",")
        return descriptionList.joinToString(separator = ",", limit =  2, truncated = "" ).dropLast(1)
    }

    fun getMinutesUntilClosed():String{
        val date = Date.from(Instant.parse(nextCloseTime))
        val currentDateTime = Date()
        val millisBetween = date.time - currentDateTime.time
        val hoursBeforeClose = (millisBetween / (1000 * 60 * 60)) % 24
        val minsBeforeClose = (millisBetween / (1000 * 60)) % 60

        var minutesUntilClosed = ""

        if(hoursBeforeClose.toInt() == 0 && minsBeforeClose.toInt() > 0){
           minutesUntilClosed = "$minsBeforeClose min(s)"
        }
        else if(hoursBeforeClose > 0){
            minutesUntilClosed = "$hoursBeforeClose hr(s)"
        }
        else if(hoursBeforeClose.toInt() < 1 && minsBeforeClose.toInt() < 1){
            minutesUntilClosed = "Closed"
        }
        return minutesUntilClosed
    }
}

