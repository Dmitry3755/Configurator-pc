package com.example.configuratorpcjetpackcompose.dependancy_injection.application

import android.app.Application
import com.example.configuratorpcjetpackcompose.utils.AppResources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ConfiguratorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppResources.initializeResources(context = this)
    }
}