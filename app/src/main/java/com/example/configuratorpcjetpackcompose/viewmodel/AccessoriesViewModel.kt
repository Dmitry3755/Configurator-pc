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

    suspend fun loadAccessory(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return configurationRepository.getListAccessoryFromDB(classAccessoryType)
    }

    suspend fun getAccessoriesUri(uriAccessory: String): Uri {
        return configurationRepository.getAccessoriesImage(uriAccessory)
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
        userConfigurationsList.addAll(configurationRepository.loadAllConfigurationsForUserFormDB())
    }


    suspend fun saveConfiguration(configuration: Configuration) {
        configurationRepository.saveConfigurationToDB(configuration)
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
        var a = 0
    }

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableStateListOf())
        }
    }
}

/*suspend fun testWriteConfigurationInDb() {
    configuration.value.motherboard = Motherboard(
        _manufacturer = "Asrock",
        _socket = "LGA 1700",
        _chipset = "Intel Z690",
        _memorySlotsCount = 0,
        _forProcesses = "",
        _typeOfSupportedMemory = "",
        _builtInWiFiAdapter = "",
        _pciExpressVersion = 0,
        _m2ConnectorsCount = 0,
        _formFactor = "",
        _energyConsumptionMax = 0,
        _memoryFrequencyMax = 0,
    ).apply {
        _idAccessory = "xVAbuSqpPB1i0mfPZsqu"
        _nameAccessory = "Материнская плата ASRock Z690 Steel Legend"
        _descriptionAccessory = ""
        _priceAccessory = 0.0
        _uriAccessory = ""
    }
    configuration.value.powerSupplyUnit = PowerSupplyUnit(
        _manufacturer = "be quiet !",
        _powerCapacity = 0,
        _certificate80Plus = "",
        _detachableCables = "",
        _formFactor = "",
        _connectorsForVideoCard = "",
        _connectorsForCpu = "",
        _coolingSystem = "",
        _powerFactorCorrector = "",
        _typeOfIllumination = "",
        _pin15SataConnectorsCounts = 0
    ).apply {
        _idAccessory = "c6Eb6yAxkmx5F5Xf8eS2"
        _nameAccessory = "Блок питания be quiet! DARK POWER PRO 12 1500W"
        _descriptionAccessory = ""
        _priceAccessory = 0.0
        _uriAccessory = ""
    }
    configuration.value.soundCard = SoundCard().apply { _idAccessory = "pkFxZCV5AnXsZFnpB8Fm" }
    configuration.value.videoCardList.add(VideoCard().apply {
        _idAccessory = "ZbpxTyJveS5BW4zJr8OW"
    })
    configuration.value.case = Case().apply { _idAccessory = "VLoHACxHg771v0YVl8P6" }
    configuration.value.monitorList.add(Monitor().apply {
        _idAccessory = "92MxcYjqmx1IiJHxk0Mt"
    })
    configuration.value.ssdList.add(Ssd().apply { _idAccessory = "gVsIlFsOfC7BLn2F01w0" })
    configuration.value.hardDriveList.add(HardDrive().apply {
        _idAccessory = "j8ZQVUyUFYAN1jOrxLW9"
    })
    configuration.value.hardDriveList.add(HardDrive().apply {
        _idAccessory = "voeZEkDYukGNAZdd6nQU"
    })
    configuration.value.soDimmList.add(SoDimm().apply { _idAccessory = "aINK4yqjPdd4suWMGrRo" })
    configuration.value.dimmList.add(Dimm().apply { _idAccessory = "ebKdfp19aRnOeQ2YyjJK" })
    configuration.value.coolerForCpu =
        CoolerForCpu().apply { _idAccessory = "dgiDLJm4sa64fmioJGn0" }
    configuration.value.coolerForCaseList.add(CoolerForCase().apply {
        _idAccessory = "iYB0T5cpGfpxnxIp1a3B"
    })
    saveConfigurationToDB(configuration.value)
}*/

