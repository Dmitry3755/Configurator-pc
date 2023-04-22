package com.example.configuratorpcjetpackcompose.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.services.getAccessoriesImage
import com.example.configuratorpcjetpackcompose.services.getListAccessoryFromDB
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoryViewModel() : ViewModel() {

    var configurationPc: MutableList<MutableList<Accessory>> = mutableListOf()
    var currentAccessory: ConfigurationElementEnum = ConfigurationElementEnum.Processor
    var listAccessory: List<Accessory> = listOf()

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
            return getAccessoriesImage(uriAccessory)
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableListOf())
        }
    }

}
