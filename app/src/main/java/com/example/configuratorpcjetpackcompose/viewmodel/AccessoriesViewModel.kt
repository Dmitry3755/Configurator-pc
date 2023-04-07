package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.Cpu
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService
import com.example.configuratorpcjetpackcompose.services.getListAccessoryFromDB
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoryViewModel() : ViewModel() {

    var configurationPc: MutableList<MutableList<Accessory>> = mutableListOf()
    var currentAccessory: ConfigurationElementEnum = ConfigurationElementEnum.Processor
    var listAccessory: List<Accessory> = listOf()

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return getListAccessoryFromDB(classAccessoryType)
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableListOf())
        }
    }

}
