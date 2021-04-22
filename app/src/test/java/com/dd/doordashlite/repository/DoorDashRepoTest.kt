package com.dd.doordashlite.repository

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dd.doordashlite.testutility.MockFileReader
import com.dd.doordashlite.viewmodels.StoreDetailViewModel
import com.dd.doordashlite.viewmodels.StoreViewModel
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@Config(maxSdk = Build.VERSION_CODES.P, minSdk = Build.VERSION_CODES.P)
class DoorDashRepoTest {
    // Subjects under test
    private lateinit var mDoorDashRepository: DoorDashRepository


    private val mMockWebServer = MockWebServer()

    private val mClient = OkHttpClient.Builder().build()

    private val mApi = Retrofit.Builder()
        .baseUrl(mMockWebServer.url("/"))
        .client(mClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())



    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }


        mDoorDashRepository = DoorDashRepository(mApi)
    }

    @After
    fun cleanUp() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
        mMockWebServer.shutdown()
    }

    @Test
    fun testSuccessfulRepositoryFeedResponse(){
        mMockWebServer.apply {
            enqueue(MockResponse().setBody(MockFileReader("store_feed_10.json").getFakeJsonResponse()))
        }

        mDoorDashRepository.getStoreFeed(37.422740, -122.139956, 0, 0)
            ?.test()
            ?.awaitDone(3, TimeUnit.SECONDS)
            ?.assertComplete()
            ?.assertValue { it.stores.size == 10 }
            ?.assertNoErrors()
    }


    @Test
    fun testSuccessfulRepositorySingleStoreResponse(){
        mMockWebServer.apply {
            enqueue(MockResponse().setBody(MockFileReader("single_store_response.json").getFakeJsonResponse()))
        }

        mDoorDashRepository.getStore(30)
            ?.test()
            ?.awaitDone(3, TimeUnit.SECONDS)
            ?.assertComplete()
            ?.assertValue { it.name == "Amarin Thai Cuisine (Mountain View)" }
            ?.assertNoErrors()
    }

}