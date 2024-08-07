package com.example.configuratorpcjetpackcompose.viewmodel

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.data.model.entities.Case
import com.example.data.model.entities.data_class.Configuration
import com.example.data.model.entities.CoolerForCase
import com.example.data.model.entities.CoolerForCpu
import com.example.data.model.entities.Cpu
import com.example.data.model.entities.Dimm
import com.example.data.model.entities.HardDrive
import com.example.data.model.entities.Monitor
import com.example.data.model.entities.Motherboard
import com.example.data.model.entities.PowerSupplyUnit
import com.example.data.model.entities.SoDimm
import com.example.data.model.entities.SoundCard
import com.example.data.model.entities.Ssd
import com.example.data.model.entities.VideoCard
import com.example.configuratorpcjetpackcompose.model.repositories.ConfigurationRepository
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoriesViewModel() : ViewModel() {

    private var configurationRepository: ConfigurationRepository = ConfigurationRepository()

    var configurationPc: MutableList<MutableList<com.example.data.entities.AccessoryApiResponse>> = mutableStateListOf()
    val listAccessory = mutableStateListOf<com.example.data.entities.AccessoryApiResponse>()
    var configuration: MutableState<com.example.data.model.entities.data_class.Configuration> = mutableStateOf(
        com.example.data.model.entities.data_class.Configuration()
    )
    val userConfigurationsList = mutableStateListOf<com.example.data.model.entities.data_class.Configuration>()
    var selectedConfiguration = mutableStateOf(com.example.data.model.entities.data_class.Configuration())

    suspend fun loadAccessory(classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>): List<com.example.data.entities.AccessoryApiResponse> {
        return configurationRepository.getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
        return configurationRepository.getAccessoriesImage(uriAccessory)
    }

    fun selectConfiguration(configuration: com.example.data.model.entities.data_class.Configuration) {
        selectedConfiguration.value = configuration
    }

    fun filterPriceAccessories(list: List<com.example.data.entities.AccessoryApiResponse>, filterPriceUpDown: Boolean) {
        listAccessory.clear()
        if (filterPriceUpDown)
            listAccessory.addAll(list.sortedByDescending { it.price })
        else
            listAccessory.addAll(list.sortedBy { it.price })
    }

    suspend fun getAccessory(
        idAccessory: String,
        classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>
    ): com.example.data.entities.AccessoryApiResponse {
        return configurationRepository.getAccessoryFromDB(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun loadAllConfigurationsForUser() {
        userConfigurationsList.clear()
        userConfigurationsList.addAll(configurationRepository.loadAllConfigurationsForUserFormDB())
    }

    suspend fun saveConfiguration(configuration: com.example.data.model.entities.data_class.Configuration) {
        configurationRepository.saveConfigurationToDB(configuration)
    }

    suspend fun updateConfiguration() {
        configurationRepository.updateConfigurationOnDB(selectedConfiguration.value)
    }

    fun addAccessoryInConfiguration(accessory: com.example.data.entities.AccessoryApiResponse) {
        when (accessory) {
            is com.example.data.model.entities.Cpu -> configuration.value.cpu = accessory
            is com.example.data.model.entities.Motherboard -> configuration.value.motherboard = accessory
            is com.example.data.model.entities.PowerSupplyUnit -> configuration.value.powerSupplyUnit = accessory
            is com.example.data.model.entities.SoundCard -> configuration.value.soundCard = accessory
            is com.example.data.model.entities.VideoCard -> configuration.value.videoCardList.add(accessory)
            is com.example.data.model.entities.Case -> configuration.value.case = accessory
            is com.example.data.model.entities.Monitor -> configuration.value.monitorList.add(accessory)
            is com.example.data.model.entities.Ssd -> configuration.value.ssdList.add(accessory)
            is com.example.data.model.entities.HardDrive -> configuration.value.hardDriveList.add(accessory)
            is com.example.data.model.entities.SoDimm -> configuration.value.soDimmList.add(accessory)
            is com.example.data.model.entities.Dimm -> configuration.value.dimmList.add(accessory)
            is com.example.data.model.entities.CoolerForCpu -> configuration.value.coolerForCpu = accessory
            is com.example.data.model.entities.CoolerForCase -> configuration.value.coolerForCaseList.add(accessory)
            else -> {}
        }
    }

    fun removeAccessoryInConfiguration(accessory: com.example.data.entities.AccessoryApiResponse) {
        when (accessory) {
            is com.example.data.model.entities.Cpu -> configuration.value.cpu = null
            is com.example.data.model.entities.Motherboard -> configuration.value.motherboard = null
            is com.example.data.model.entities.PowerSupplyUnit -> configuration.value.powerSupplyUnit = null
            is com.example.data.model.entities.SoundCard -> configuration.value.soundCard = null
            is com.example.data.model.entities.VideoCard -> configuration.value.videoCardList.remove(accessory)
            is com.example.data.model.entities.Case -> configuration.value.case = null
            is com.example.data.model.entities.Monitor -> configuration.value.monitorList.remove(accessory)
            is com.example.data.model.entities.Ssd -> configuration.value.ssdList.remove(accessory)
            is com.example.data.model.entities.HardDrive -> configuration.value.hardDriveList.remove(accessory)
            is com.example.data.model.entities.SoDimm -> configuration.value.soDimmList.remove(accessory)
            is com.example.data.model.entities.Dimm -> configuration.value.dimmList.remove(accessory)
            is com.example.data.model.entities.CoolerForCpu -> configuration.value.coolerForCpu = null
            is com.example.data.model.entities.CoolerForCase -> configuration.value.coolerForCaseList.remove(accessory)
            else -> {}
        }
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableStateListOf())
        }
    }
}

