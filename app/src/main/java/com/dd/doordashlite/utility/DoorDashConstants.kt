package com.dd.doordashlite.utility

class DoorDashConstants {
    companion object{
        const val BASE_URL = "https://api.doordash.com/"
        const val STORE_FEED_PATH = "v1/store_feed/"
        const val STORE_FEED_PATH_LATITUDE = "lat"
        const val STORE_FEED_PATH_LONGITUDE = "lng"
        const val STORE_FEED_PATH_LIMIT = "limit"
        const val STORE_FEED_PATH_OFFSET = "offset"

        const val STORE_PATH = "v2/restaurant/{id}/"
        const val STORE_PATH_ID = "id"
    }
}