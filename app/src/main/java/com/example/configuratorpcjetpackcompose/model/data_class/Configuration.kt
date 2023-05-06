package com.example.configuratorpcjetpackcompose.model.data_class

import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.firebase_data_class.FbConfiguration
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError
import com.google.firebase.firestore.PropertyName

data class Configuration(
    val id: String = "",
    @PropertyName("cpu")
    var cpu: Cpu? = null,
    @PropertyName("motherboard")
    var motherboard: Motherboard? = null,
    @PropertyName("dimm_list")
    var dimmList: ArrayList<Dimm> = arrayListOf(),
    @PropertyName("sodimm_list")
    var soDimmList: ArrayList<SoDimm> = arrayListOf(),
    @PropertyName("power_supply_unit")
    var powerSupplyUnit: PowerSupplyUnit? = null,
    @PropertyName("sound_card")
    var soundCard: SoundCard? = null,
    @PropertyName("video_card_list")
    var videoCardList: ArrayList<VideoCard> = arrayListOf(),
    @PropertyName("cooler_for_case_list")
    var coolerForCaseList: ArrayList<CoolerForCase> = arrayListOf(),
    @PropertyName("cooler_for_cpu")
    var coolerForCpu: CoolerForCpu? = null,
    @PropertyName("case")
    var case: Case? = null,
    @PropertyName("monitor_list")
    var monitorList: ArrayList<Monitor> = arrayListOf(),
    @PropertyName("hard_drive_list")
    var hardDriveList: ArrayList<HardDrive> = arrayListOf(),
    @PropertyName("ssd_list")
    var ssdList: ArrayList<Ssd> = arrayListOf(),
    @PropertyName("user_owner")
    var userOwner: User? = null,
) {
    fun checkAccessoryInConfiguration(configurationElementList: List<Class<out Accessory>>): Boolean {
        for (element in configurationElementList) {
            when (element) {
                Cpu::class.java -> if (cpu != null) return true
                Motherboard::class.java -> if (motherboard != null) return true
                PowerSupplyUnit::class.java -> if (powerSupplyUnit != null) return true
                SoundCard::class.java -> if (soundCard != null) return true
                Case::class.java -> if (case != null) return true
                VideoCard::class.java -> if (videoCardList.isNotEmpty()) return true
                Ssd::class.java -> if (ssdList.isNotEmpty()) return true
                HardDrive::class.java -> if (hardDriveList.isNotEmpty()) return true
                SoDimm::class.java -> if (soDimmList.isNotEmpty()) return true
                CoolerForCase::class.java -> if (coolerForCaseList.isNotEmpty()) return true
                CoolerForCpu::class.java -> if (coolerForCpu != null) return true
                Monitor::class.java -> if (monitorList.isNotEmpty()) return true
            }
        }
        return false
    }

    fun checkingCompatibility(): ConfigurationError {
        /*TODO: 1) Проверка на совместимость сокетов (cpu  и motherboard) +
         TODO:  2) Проверка на совместимость форм-фактора мат.платы  и корпуса +
         TODO:  3) Проверка на совместимость сокетов (motherboard and coolerForCpu) +
         TODO:  4) Проверка на совместимоть RAM (DIMM and So-DIMM) с мат.платой +
         TODO:  5) Проверка на совместимость разъемов питания процессора на блоке питания (pin cpu) +
         TODO:  6) Проверка по габаритам видеокарты и корпуса +
         TODO:  7)
         TODO:  8)
         TODO:  9)

         */
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }
}

fun Configuration.toFbConfiguration(): FbConfiguration {
    return FbConfiguration(
        cpuId = this.cpu!!._idAccessory,
        motherboardId = this.motherboard!!._idAccessory,
        powerSupplyUnitId = this.powerSupplyUnit!!._idAccessory,
        dimmIdsList = this.dimmList.map { it._idAccessory }.toMutableList(),
        soDimmIdsList = this.soDimmList.map { it._idAccessory }.toMutableList(),
        soundCardId = this.soundCard!!._idAccessory,
        videoCardIdsList = this.videoCardList.map { it._idAccessory }.toMutableList(),
        coolerForCaseIdsList = this.coolerForCaseList.map { it._idAccessory }.toMutableList(),
        coolerForCpuId = this.coolerForCpu!!._idAccessory,
        caseId = this.case!!._idAccessory,
        monitorIdsList = this.monitorList.map { it._idAccessory }.toMutableList(),
        hardDriveIdsList = this.hardDriveList.map { it._idAccessory }.toMutableList(),
        ssdIdsList = this.ssdList.map { it._idAccessory }.toMutableList()
    )
}

/*    if (checkingTheRequiredComponents().isError.value) {
        return checkingTheRequiredComponents()
    }

    var energy = calcEnergy()

    if (cpu?._socket!= motherboard?.socket) {
        DataResult.Error(
            exception = Exception(
                AppResources.getString(R.string.error_configuration_processor_socket)
            )
        )
    }
   /* for (caseFormFactor in case?.formFactorOfCompatibleBoards!!) {
        if (motherboard?.formFactor != caseFormFactor) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_case_does_not_support_form_factor_of_motherboard)
                )
            )
        }
    }*/
    for (coolerSocket in coolerForCpu?.socket!!) {
        if (coolerSocket != motherboard?.socket) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_cpu_cooler_does_not_support_motherboard_socket)
                )
            )
        }
    }

    for (ram in dimmRamList) {
        if (motherboard?.typeOfSupportedMemory != ram.memoryType) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram)
                )
            )
        }
    }
    for (ram in soDimmRamList) {
        if (motherboard?.typeOfSupportedMemory != ram.memoryType) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram)
                )
            )
        }
    }
    if (powerSupplyUnit?.connectorsForCpu != cpu?._pinConnector) {
        DataResult.Error(
            exception = Exception(
                AppResources.getString(R.string.error_configuration_pin_cpu_is_not_compatible)
            )
        )
    }
    for (videoCard in videoCardList) {
        if (videoCard.length > case?.lengthMaxOfVideoCard!!) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_case_does_not_support_size_of_video_card)
                )
            )
        }
        energy += videoCard.energyConsumptionMax
        if (energy >= powerSupplyUnit?.powerCapacity!!) {
            DataResult.Error(
                exception = Exception(
                    AppResources.getString(R.string.error_configuration_case_does_not_support_size_of_video_card)
                )
            )
        }
    }
    return ConfigurationError(
        isError = mutableStateOf(false),
        errorMessage = mutableStateOf("success")
    )
}

fun calcEnergy(): Int {
    var energy = 0
    energy = cpu?._heatDissipation!! + motherboard?.energyConsumptionMax!! + 50
    return energy
}

fun checkingTheRequiredComponents(): ConfigurationError {
    if (cpu == null) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_is_empty))
        )
    }
    if (motherboard == null) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_is_empty))
        )
    }
    if (case == null) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_case_is_empty))
        )
    }
    if (coolerForCpu == null) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cooler_for_cpu_is_empty))
        )
    }
    if ((dimmRamList.isEmpty()) && (soDimmRamList.isEmpty())) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_ram_is_empty))
        )
    }
    if ((ssdStoreList.isEmpty()) && (hardDriveList.isEmpty())) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_data_storage_is_empty))
        )
    }
    if (powerSupplyUnit == null) {
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_power_supply_unit_is_empty))
        )
    }
    if (videoCardList.isEmpty()) {
        if (cpu?._integratedGraphicsCore == false) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_without_integrated_graphics_core))
            )
        }
    }
    return ConfigurationError(
        isError = mutableStateOf(false),
        errorMessage = mutableStateOf("success")
    )
} */
