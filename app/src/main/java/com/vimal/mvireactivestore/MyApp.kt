package com.vimal.mvireactivestore

import android.app.Application
import com.vimal.mvireactivestore.BuildConfig
import timber.log.Timber

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}