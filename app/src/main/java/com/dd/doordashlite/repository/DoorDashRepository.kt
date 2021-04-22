package com.dd.doordashlite.repository

import com.dd.doordashlite.api.DoorDashService
import com.dd.doordashlite.api.SingleStoreResponse
import com.dd.doordashlite.api.StoreResponse
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit

class DoorDashRepository(api: Retrofit.Builder) {

    private val mDoorDashService: DoorDashService = api
        .build()
        .create(DoorDashService::class.java)



    fun getStoreFeed(
        lat: Double,
        lng: Double,
        offset: Int,
        limit: Int
    ): @NonNull Flowable<StoreResponse>? {
        return mDoorDashService.getStores(lat, lng, offset, limit)
            .subscribeOn(Schedulers.io())
    }


    fun getStore(id: Int): @NonNull Flowable<SingleStoreResponse>? {
        return mDoorDashService.getStore(id)
            .subscribeOn(Schedulers.io())
    }


}
