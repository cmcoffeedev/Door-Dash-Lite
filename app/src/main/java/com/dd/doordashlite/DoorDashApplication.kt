package com.dd.doordashlite

import android.app.Application
import com.dd.doordashlite.api.DoorDashClient
import com.dd.doordashlite.repository.DoorDashRepository

class DoorDashApplication: Application() {

    val repository by lazy { DoorDashRepository(DoorDashClient().getApi()) }
}