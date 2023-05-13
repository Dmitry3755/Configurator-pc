package com.example.configuratorpcjetpackcompose.model.data_class

import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.model.firebase_data_class.FbConfiguration
import com.example.configuratorpcjetpackcompose.utils.AppResources
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError
import com.google.firebase.firestore.PropertyName

data class Configuration(
    val id: String = "",
    @PropertyName("cpu")
    var cpu: Cpu? = null,
    @PropertyName("motherboard")
    var motherboard: Motherboard? = null,
    @PropertyName("dimm_list")
    var dimmList: MutableList<Dimm> = mutableListOf(),
    @PropertyName("sodimm_list")
    var soDimmList: MutableList<SoDimm> = mutableListOf(),
    @PropertyName("power_supply_unit")
    var powerSupplyUnit: PowerSupplyUnit? = null,
    @PropertyName("sound_card")
    var soundCard: SoundCard? = null,
    @PropertyName("video_card_list")
    var videoCardList: MutableList<VideoCard> = mutableListOf(),
    @PropertyName("cooler_for_case_list")
    var coolerForCaseList: MutableList<CoolerForCase> = mutableListOf(),
    @PropertyName("cooler_for_cpu")
    var coolerForCpu: CoolerForCpu? = null,
    @PropertyName("case")
    var case: Case? = null,
    @PropertyName("monitor_list")
    var monitorList: MutableList<Monitor> = mutableListOf(),
    @PropertyName("hard_drive_list")
    var hardDriveList: MutableList<HardDrive> = mutableListOf(),
    @PropertyName("ssd_list")
    var ssdList: MutableList<Ssd> = mutableListOf(),
    @PropertyName("user_owner")
    var userOwner: User? = null,
) {

    fun getListAccessoryFromConfiguration(configurationElementList: Class<out Accessory>): List<Accessory> {
        when (configurationElementList) {
            VideoCard::class.java -> if (videoCardList.isNotEmpty()) return videoCardList
            Ssd::class.java -> if (ssdList.isNotEmpty()) return ssdList
            Dimm::class.java -> if (dimmList.isNotEmpty()) return dimmList
            HardDrive::class.java -> if (hardDriveList.isNotEmpty()) return hardDriveList
            SoDimm::class.java -> if (soDimmList.isNotEmpty()) return soDimmList
            CoolerForCase::class.java -> if (coolerForCaseList.isNotEmpty()) return coolerForCaseList
            Monitor::class.java -> if (monitorList.isNotEmpty()) return monitorList
        }
        return listOf()
    }

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

    fun getAccessoryFromConfiguration(configurationElementList: Class<out Accessory>): Accessory {
        when (configurationElementList) {
            Cpu::class.java -> if (cpu != null) return cpu!!
            Motherboard::class.java -> if (motherboard != null) return motherboard!!
            PowerSupplyUnit::class.java -> if (powerSupplyUnit != null) return powerSupplyUnit!!
            SoundCard::class.java -> if (soundCard != null) return soundCard!!
            Case::class.java -> if (case != null) return case!!
            VideoCard::class.java -> if (videoCardList.isNotEmpty()) {
                for (videoCard in videoCardList) {
                    return videoCard
                }
            }

            Ssd::class.java -> if (ssdList.isNotEmpty()) {
                for (ssd in ssdList) {
                    return ssd
                }
            }

            HardDrive::class.java -> if (hardDriveList.isNotEmpty()) {
                for (hardDrive in hardDriveList) {
                    return hardDrive
                }
            }

            SoDimm::class.java -> if (soDimmList.isNotEmpty()) {
                for (soDimm in soDimmList) {
                    return soDimm
                }
            }

            CoolerForCase::class.java -> if (coolerForCaseList.isNotEmpty()) {
                for (coolerForCase in coolerForCaseList) {
                    return coolerForCase
                }
            }

            CoolerForCpu::class.java -> if (coolerForCpu != null) return coolerForCpu!!
            Monitor::class.java -> if (monitorList.isNotEmpty()) {
                for (monitor in monitorList) {
                    return monitor
                }
            }
        }
        return Accessory(_categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD)
    }

    fun checkingCompatibility(): ConfigurationError {

        if (checkingRequiredComponents().isError.value) {
            return checkingRequiredComponents()
        }
        if (checkingSocketCpuMotherboardCompatibility().isError.value) {
            return checkingSocketCpuMotherboardCompatibility()
        }
        if (checkingFormFactorCompatibility().isError.value) {
            return checkingFormFactorCompatibility()
        }
        if (checkingSocketCoolerMotherboardCompatibility().isError.value) {
            return checkingSocketCoolerMotherboardCompatibility()
        }
        if (checkingDimmMotherboardCompatibility().isError.value) {
            return checkingDimmMotherboardCompatibility()
        }
        if (checkingSoDimmMotherboardCompatibility().isError.value) {
            return checkingSoDimmMotherboardCompatibility()
        }
        if (checkingMaxCountRamSlotsOnMotherboardCompatibility().isError.value) {
            return checkingMaxCountRamSlotsOnMotherboardCompatibility()
        }
        if (checkingMaxLengthVideoCardOnCaseCompatibility().isError.value) {
            return checkingMaxLengthVideoCardOnCaseCompatibility()
        }
        if (checkingMaxCountVideoCardSlotsOnMotherboardCompatibility().isError.value) {
            return checkingMaxCountVideoCardSlotsOnMotherboardCompatibility()
        }

        if ((calculateConsumptionEnergy() * 100) / powerSupplyUnit!!._powerCapacity > 90) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_configuration_maximum_power_configuration_greater_than_power_supply)
                )
            )

        }

        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingRequiredComponents(): ConfigurationError {
        if (cpu == null) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_is_empty))
            )
        }
        if (motherboard == null) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_is_empty))
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
        if ((dimmList.isEmpty()) && (soDimmList.isEmpty())) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_ram_is_empty))
            )
        }
        if ((ssdList.isEmpty()) && (hardDriveList.isEmpty())) {
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
        if (videoCardList.isEmpty() && cpu?._integratedGraphicsCore == false) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_without_integrated_graphics_core))
            )
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun calculateConsumptionEnergy(): Int {
        var energy = cpu!!._heatDissipation + 5 //энергопотребление процессора и куллера
        for (videCard in videoCardList) {
            energy += videCard._energyConsumptionMax
        }
        for (ssd in ssdList) {
            energy += 15 // Ср. потребление ssd диска
        }
        for (hardDrive in hardDriveList) {
            energy += when (hardDrive._spindleRotationSpeed) {
                in 0..6000 -> 10 // Ср. потребление HDD диска до 6000 rmp
                in 6001..7200 -> 15 // Ср. потребление HDD диска до 7200 rmp
                in 7201..15000 -> 20 // Ср. потребление HDD диска до 15000 rmp
                else -> 20
            }
        }
        for (i in 0..case!!._fansCount) {
            energy += 5
        }
        energy += when (motherboard!!.formFactor) {
            "Standard-ATX" -> 70
            "Micro-ATX" -> 60
            "Mini-ATX" -> 30
            "Mini-ITX" -> 20
            "SSI-CEB" -> 150
            "SSI-EEB" -> 150
            "XL ATX" -> 130
            "ATX" -> 70
            else -> 50
        }
        return energy
    }

    private fun checkingSocketCpuMotherboardCompatibility(): ConfigurationError {
        if (cpu?._socket != motherboard?.socket) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_processor_socket))
            )
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingMaxCountVideoCardSlotsOnMotherboardCompatibility(): ConfigurationError {
        var pin16Connector = 0
        for (slotsForVideoCardCount in motherboard!!._slotsForVideoCardsList) {
            if (slotsForVideoCardCount.substring(2, slotsForVideoCardCount.length) == "PCI-E x16") {
                pin16Connector = slotsForVideoCardCount[0].digitToInt()
            }
        }
        if (videoCardList.size > pin16Connector) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_doesnt_support_much_video_card))
            )
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingMaxCountRamSlotsOnMotherboardCompatibility(): ConfigurationError {
        if (dimmList.size > motherboard!!.memorySlotsCount) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_doesnt_support_much_RAM))
            )
        }
        if (soDimmList.size > motherboard!!.memorySlotsCount) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_doesnt_support_much_RAM))
            )
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingFormFactorCompatibility(): ConfigurationError {
        for (caseFormFactor in case?.formFactorOfCompatibleBoards!!) {
            if (motherboard?.formFactor == caseFormFactor) {
                return ConfigurationError(
                    isError = mutableStateOf(false),
                    errorMessage = mutableStateOf("success")
                )
            }
        }
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_case_does_not_support_form_factor_of_motherboard))
        )
    }

    private fun checkingSocketCoolerMotherboardCompatibility(): ConfigurationError {
        for (coolerSocket in coolerForCpu?.socket!!) {
            if (coolerSocket == motherboard?.socket) {
                return ConfigurationError(
                    isError = mutableStateOf(false),
                    errorMessage = mutableStateOf("success")
                )

            }
        }
        return ConfigurationError(
            isError = mutableStateOf(true),
            errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_cpu_cooler_does_not_support_motherboard_socket))
        )
    }

    private fun checkingDimmMotherboardCompatibility(): ConfigurationError {
        for (ram in dimmList) {
            if (motherboard?.typeOfSupportedMemory != ram.memoryType) {
                return ConfigurationError(
                    isError = mutableStateOf(true),
                    errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram))
                )
            }
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingSoDimmMotherboardCompatibility(): ConfigurationError {
        for (ram in soDimmList) {
            if (motherboard?.typeOfSupportedMemory != ram.memoryType) {
                return ConfigurationError(
                    isError = mutableStateOf(true),
                    errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram))
                )
            }
        }
        return ConfigurationError(
            isError = mutableStateOf(false),
            errorMessage = mutableStateOf("success")
        )
    }

    private fun checkingMaxLengthVideoCardOnCaseCompatibility(): ConfigurationError {
        for (videoCard in videoCardList) {
            if (videoCard.length > case?.lengthMaxOfVideoCard!!) {
                return ConfigurationError(
                    isError = mutableStateOf(true),
                    errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_case_does_not_support_size_of_video_card))
                )
            }
        }
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


