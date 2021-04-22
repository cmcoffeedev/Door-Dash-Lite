package com.dd.doordashlite.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dd.doordashlite.api.SingleStoreResponse
import com.dd.doordashlite.api.asDomainModel
import com.dd.doordashlite.domain.StoreDetail
import com.dd.doordashlite.repository.DoorDashRepository
import com.dd.doordashlite.repository.Status
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subscribers.ResourceSubscriber

class StoreDetailViewModel(private val repository: DoorDashRepository): ViewModel() {

    val store: MutableLiveData<StoreDetail> = MutableLiveData()
    val status: MutableLiveData<Status> = MutableLiveData()
    private val mDisposables = CompositeDisposable()

    init {
        status.postValue(Status.LOADING)
    }



    fun loadStore(storeId: Int) {
        mDisposables.add(
        repository.getStore(storeId)?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeWith(object : ResourceSubscriber<SingleStoreResponse>() {
                override fun onNext(t: SingleStoreResponse?) {
                    val storeDetail = t?.asDomainModel()
                    store.postValue(storeDetail)
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