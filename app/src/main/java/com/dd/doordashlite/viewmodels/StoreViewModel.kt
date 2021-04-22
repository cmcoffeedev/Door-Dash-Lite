package com.dd.doordashlite.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dd.doordashlite.api.StoreResponse
import com.dd.doordashlite.api.asDomainModel
import com.dd.doordashlite.domain.Store
import com.dd.doordashlite.repository.DoorDashRepository
import com.dd.doordashlite.repository.Status
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subscribers.ResourceSubscriber


class StoreViewModel(private val repository: DoorDashRepository) : ViewModel() {

    val storeList: MutableLiveData<List<Store>> = MutableLiveData()
    val status: MutableLiveData<Status> = MutableLiveData()
    private val mDisposables = CompositeDisposable()

    init {
        status.postValue(Status.LOADING)
    }

    fun loadStores() {
        mDisposables.add(
            repository.getStoreFeed(37.422740, -122.139956, 0, 10)?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : ResourceSubscriber<StoreResponse>() {
                    override fun onNext(t: StoreResponse?) {
                        val list = t?.asDomainModel()
                        storeList.postValue(list)
                        status.postValue(Status.SUCCESS)
                    }

                    override fun onError(t: Throwable?) {
                        status.postValue(Status.ERROR)
                    }

                    override fun onComplete() {
                    }

                }))
    }

    override fun onCleared() {
        mDisposables.dispose()
        super.onCleared()
    }


}