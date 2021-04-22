package com.dd.doordashlite.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.doordashlite.repository.DoorDashRepository

class StoreViewModelFactory(private val repository: DoorDashRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StoreViewModel(repository) as T
        }
        else if (modelClass.isAssignableFrom(StoreDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StoreDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}