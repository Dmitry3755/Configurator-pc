package com.example.configuratorpcjetpackcompose.viewmodel

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.dataclass.Case
import com.example.configuratorpcjetpackcompose.model.dataclass.Configuration
import com.example.configuratorpcjetpackcompose.model.dataclass.CoolerForCase
import com.example.configuratorpcjetpackcompose.model.dataclass.CoolerForCpu
import com.example.configuratorpcjetpackcompose.model.dataclass.Cpu
import com.example.configuratorpcjetpackcompose.model.dataclass.Dimm
import com.example.configuratorpcjetpackcompose.model.dataclass.HardDrive
import com.example.configuratorpcjetpackcompose.model.dataclass.Monitor
import com.example.configuratorpcjetpackcompose.model.dataclass.Motherboard
import com.example.configuratorpcjetpackcompose.model.dataclass.PowerSupplyUnit
import com.example.configuratorpcjetpackcompose.model.dataclass.SoDimm
import com.example.configuratorpcjetpackcompose.model.dataclass.SoundCard
import com.example.configuratorpcjetpackcompose.model.dataclass.Ssd
import com.example.configuratorpcjetpackcompose.model.dataclass.VideoCard
import com.example.configuratorpcjetpackcompose.services.getAccessoriesImage
import com.example.configuratorpcjetpackcompose.services.getAccessoryFromDB
import com.example.configuratorpcjetpackcompose.services.getListAccessoryFromDB
import com.example.configuratorpcjetpackcompose.services.saveConfigurationToDB
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoryViewModel() : ViewModel() {

    var configurationPc: MutableList<MutableList<Accessory>> = mutableStateListOf()
    val listAccessory = mutableStateListOf<Accessory>()
    var configuration: MutableState<Configuration> = mutableStateOf(Configuration())

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
        return getAccessoriesImage(uriAccessory)
    }

    fun filterPriceAccessories(list: List<Accessory>, filterPriceUpDown: Boolean) {
        listAccessory.clear()
        if (filterPriceUpDown)
            listAccessory.addAll(list.sortedByDescending { it.price })
        else
            listAccessory.addAll(list.sortedBy { it.price })
    }

    suspend fun getAccessory(
        idAccessory: String,
        classAccessoryType: Class<out Accessory>
    ): Accessory {
        return getAccessoryFromDB(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun saveConfiguration(configuration: Configuration) {
        saveConfigurationToDB(configuration)
    }
    fun addAccessoryInConfiguration(accessory: Accessory) {
        when (accessory) {
            is Cpu -> configuration.value.cpu = accessory
            is Motherboard -> configuration.value.motherboard = accessory
            is PowerSupplyUnit -> configuration.value.powerSupplyUnit = accessory
            is SoundCard -> configuration.value.soundCard = accessory
            is VideoCard -> configuration.value.videoCardList.add(accessory)
            is Case -> configuration.value.case = accessory
            is Monitor -> configuration.value.monitorList.add(accessory)
            is Ssd -> configuration.value.ssdList.add(accessory)
            is HardDrive -> configuration.value.hardDriveList.add(accessory)
            is SoDimm -> configuration.value.soDimmList.add(accessory)
            is Dimm -> configuration.value.dimmList.add(accessory)
            is CoolerForCpu -> configuration.value.coolerForCpu = accessory
            is CoolerForCase -> configuration.value.coolerForCaseList.add(accessory)
            else -> {}
        }
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableStateListOf())
        }
    }
}
