package com.mowael.uae_universties

import android.app.Application
import com.mowael.core.di.AppModule
import com.mowael.core.di.DaggerAppComponent

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
}