package com.example.configuratorpcjetpackcompose.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.services.getAccessoriesImage
import com.example.configuratorpcjetpackcompose.services.getListAccessoryFromDB
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoryViewModel() : ViewModel() {

    var configurationPc: MutableList<MutableList<Accessory>> = mutableListOf()
    var currentAccessory: ConfigurationElementEnum = ConfigurationElementEnum.Processor
    val listAccessory = mutableStateListOf<Accessory>()

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
        return getAccessoriesImage(uriAccessory)
    }

    fun filterPriceAccessories(list: List<Accessory>, filterPriceUpDown: Boolean) {
        listAccessory.clear()
        if (filterPriceUpDown)
            listAccessory.addAll(list.sortedByDescending { it.priceAccessory })
        else
            listAccessory.addAll(list.sortedBy { it.priceAccessory })
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableListOf())
        }
    }

}
