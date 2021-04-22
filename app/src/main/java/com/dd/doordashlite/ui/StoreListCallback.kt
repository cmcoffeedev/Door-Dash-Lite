package com.dd.doordashlite.ui

import com.dd.doordashlite.domain.Store


interface StoreListCallback {
    fun clickedStore(store: Store)
}