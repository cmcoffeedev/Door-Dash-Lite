package com.dd.doordashlite.api

import com.dd.doordashlite.utility.DoorDashConstants
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DoorDashService {
    @GET(DoorDashConstants.STORE_FEED_PATH)
    fun getStores(
        @Query(DoorDashConstants.STORE_FEED_PATH_LATITUDE) lat: Double,
        @Query(DoorDashConstants.STORE_FEED_PATH_LONGITUDE) lng: Double,
        @Query(DoorDashConstants.STORE_FEED_PATH_OFFSET) offset: Int,
        @Query(DoorDashConstants.STORE_FEED_PATH_LIMIT) limit: Int
    ): Flowable<StoreResponse>


    @GET(DoorDashConstants.STORE_PATH)
    fun getStore(
        @Path(DoorDashConstants.STORE_PATH_ID) id: Int
    ): Flowable<SingleStoreResponse>



}