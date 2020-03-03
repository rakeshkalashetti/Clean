package com.gubb.cleana

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.gubb.cleana.core.di.AppComponent
import com.gubb.cleana.core.di.DaggerAppComponent

class ApplicationLoader : Application() {

    init {
        applicationLoader = this
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(applicationLoader).build()
    }

    companion object {
        lateinit var applicationLoader: ApplicationLoader
            private set

        val applicationContext: Context
            get() {
                return applicationLoader.applicationContext
            }
    }

    fun hasNetwork(): Boolean {
        return isNetworkAvailable()
    }

    private fun isNetworkAvailable(): Boolean {
        var isConnected = false
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}