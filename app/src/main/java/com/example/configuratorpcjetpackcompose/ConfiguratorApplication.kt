package com.example.configuratorpcjetpackcompose

import android.app.Application
import com.example.configuratorpcjetpackcompose.utils.AppResources

class ConfiguratorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppResources.initializeResources(context = this)
    }
}