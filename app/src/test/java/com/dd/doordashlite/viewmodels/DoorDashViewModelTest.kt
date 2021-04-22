package com.dd.doordashlite.viewmodels

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dd.doordashlite.api.SingleStoreResponse
import com.dd.doordashlite.api.StoreResponse
import com.dd.doordashlite.domain.Store
import com.dd.doordashlite.domain.StoreDetail
import com.dd.doordashlite.repository.DoorDashRepository
import com.dd.doordashlite.repository.Status
import com.dd.doordashlite.testutility.MockFileReader
import com.google.gson.Gson
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.Assert
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.kotlin.doReturn
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(maxSdk = Build.VERSION_CODES.P, minSdk = Build.VERSION_CODES.P)
class DoorDashViewModelTest {

    // Subjects under test
    private lateinit var mStoreViewModel: StoreViewModel
    private lateinit var mStoreDetailViewModel: StoreDetailViewModel

    @Mock
    private lateinit var mDoorDashRepository: DoorDashRepository


    private val mMockWebServer = MockWebServer()


    @Mock
    var mStoreFeedObserver: Observer<List<Store>>? = null

    @Mock
    var mStoreFeedStatusObserver: Observer<Status>? = null

    @Mock
    var mStoreObserver: Observer<StoreDetail>? = null

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        val gson = Gson()
        val fakeResponse = gson.fromJson(
            MockFileReader("store_feed_10.json").getFakeJsonResponse(),
            StoreResponse::class.java
        )

        val fakeStoreDetailResponse = gson.fromJson(
            MockFileReader("single_store_response.json").getFakeJsonResponse(),
            SingleStoreResponse::class.java
        )

        mDoorDashRepository = org.mockito.kotlin.mock {
            on {
                getStoreFeed(37.422740, -122.139956, 0, 0)
            } doReturn Flowable.just(fakeResponse)

            on {
                getStore(30)
            } doReturn (Flowable.just(fakeStoreDetailResponse))


        }


        mStoreViewModel = StoreViewModel(mDoorDashRepository)
        mStoreDetailViewModel = StoreDetailViewModel(mDoorDashRepository)


        mStoreFeedObserver?.let { mStoreViewModel.storeList.observeForever(it) }
        mStoreFeedStatusObserver?.let { mStoreViewModel.status.observeForever(it) }

        mStoreObserver?.let { mStoreDetailViewModel.store.observeForever(it) }
    }

    @After
    fun cleanUp() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
        mMockWebServer.shutdown()
    }


    @Test
    fun testViewModelStoreFeed() {

        mStoreViewModel.loadStores()

        Assert.assertEquals(Status.SUCCESS, mStoreViewModel.status.value)
        Assert.assertEquals(10, mStoreViewModel.storeList.value?.size)
    }

    @Test
    fun testStoreDetailViewModel() {

        mStoreDetailViewModel.loadStore(30)

        Assert.assertEquals(Status.SUCCESS, mStoreDetailViewModel.status.value)
        Assert.assertEquals(
            "Amarin Thai Cuisine (Mountain View)",
            mStoreDetailViewModel.store.value?.name
        )
    }


}