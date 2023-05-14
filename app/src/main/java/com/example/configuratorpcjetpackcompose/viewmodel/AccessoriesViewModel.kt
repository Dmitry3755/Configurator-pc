package com.example.configuratorpcjetpackcompose.viewmodel

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.data_class.Case
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.model.data_class.CoolerForCase
import com.example.configuratorpcjetpackcompose.model.data_class.CoolerForCpu
import com.example.configuratorpcjetpackcompose.model.data_class.Cpu
import com.example.configuratorpcjetpackcompose.model.data_class.Dimm
import com.example.configuratorpcjetpackcompose.model.data_class.HardDrive
import com.example.configuratorpcjetpackcompose.model.data_class.Monitor
import com.example.configuratorpcjetpackcompose.model.data_class.Motherboard
import com.example.configuratorpcjetpackcompose.model.data_class.PowerSupplyUnit
import com.example.configuratorpcjetpackcompose.model.data_class.SoDimm
import com.example.configuratorpcjetpackcompose.model.data_class.SoundCard
import com.example.configuratorpcjetpackcompose.model.data_class.Ssd
import com.example.configuratorpcjetpackcompose.model.data_class.VideoCard
import com.example.configuratorpcjetpackcompose.model.repositories.ConfigurationRepository
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

class AccessoriesViewModel() : ViewModel() {

    private var configurationRepository: ConfigurationRepository = ConfigurationRepository()

    var configurationPc: MutableList<MutableList<Accessory>> = mutableStateListOf()
    val listAccessory = mutableStateListOf<Accessory>()
    var configuration: MutableState<Configuration> = mutableStateOf(Configuration())
    val userConfigurationsList = mutableStateListOf<Configuration>()
    var selectedConfiguration = mutableStateOf(Configuration())

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return configurationRepository.getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
        return configurationRepository.getAccessoriesImage(uriAccessory)
    }

    fun selectConfiguration(configuration: Configuration) {
        selectedConfiguration.value = configuration
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
        return configurationRepository.getAccessoryFromDB(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun loadAllConfigurationsForUser() {
        userConfigurationsList.clear()
        userConfigurationsList.addAll(configurationRepository.loadAllConfigurationsForUserFormDB())
    }

    suspend fun saveConfiguration(configuration: Configuration) {
        configurationRepository.saveConfigurationToDB(configuration)
    }

    suspend fun updateConfiguration() {
        configurationRepository.updateConfigurationOnDB(selectedConfiguration.value)
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

    fun removeAccessoryInConfiguration(accessory: Accessory) {
        when (accessory) {
            is Cpu -> configuration.value.cpu = null
            is Motherboard -> configuration.value.motherboard = null
            is PowerSupplyUnit -> configuration.value.powerSupplyUnit = null
            is SoundCard -> configuration.value.soundCard = null
            is VideoCard -> configuration.value.videoCardList.remove(accessory)
            is Case -> configuration.value.case = null
            is Monitor -> configuration.value.monitorList.remove(accessory)
            is Ssd -> configuration.value.ssdList.remove(accessory)
            is HardDrive -> configuration.value.hardDriveList.remove(accessory)
            is SoDimm -> configuration.value.soDimmList.remove(accessory)
            is Dimm -> configuration.value.dimmList.remove(accessory)
            is CoolerForCpu -> configuration.value.coolerForCpu = null
            is CoolerForCase -> configuration.value.coolerForCaseList.remove(accessory)
            else -> {}
        }
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableStateListOf())
        }
    }
}

