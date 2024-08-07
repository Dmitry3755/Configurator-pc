package com.example.data.entities

import com.example.data.entities.main_components.CaseApiResponse
import com.example.data.entities.main_components.CpuApiResponse
import com.example.data.entities.main_components.MotherboardApiResponse
import com.example.data.entities.main_components.PowerSupplyUnitApiResponse
import com.example.data.entities.main_components.VideoCardApiResponse
import com.example.data.entities.main_components.cooling.CoolerForCaseApiResponse
import com.example.data.entities.main_components.cooling.CoolerForCpuApiResponse
import com.example.data.entities.main_components.data_storage.HardDriveApiResponse
import com.example.data.entities.main_components.data_storage.SsdApiResponse
import com.example.data.entities.main_components.ram.DimmApiResponse
import com.example.data.entities.main_components.ram.SoDimmApiResponse
import com.example.data.entities.secondary_components.MonitorApiResponse
import com.example.data.entities.secondary_components.SoundCardApiResponse
import com.google.firebase.firestore.PropertyName

data class ConfigurationApiResponse(
    val id: String = "",
    @PropertyName("name_configuration")
    var nameConfiguration: String = "",
    @PropertyName("cpu")
    var cpu: CpuApiResponse? = null,
    @PropertyName("motherboard")
    var motherboard: MotherboardApiResponse? = null,
    @PropertyName("dimm_list")
    var dimmList: MutableList<DimmApiResponse> = mutableListOf(),
    @PropertyName("sodimm_list")
    var soDimmList: MutableList<SoDimmApiResponse> = mutableListOf(),
    @PropertyName("power_supply_unit")
    var powerSupplyUnit: PowerSupplyUnitApiResponse? = null,
    @PropertyName("sound_card")
    var soundCard: SoundCardApiResponse? = null,
    @PropertyName("video_card_list")
    var videoCardList: MutableList<VideoCardApiResponse> = mutableListOf(),
    @PropertyName("cooler_for_case_list")
    var coolerForCaseList: MutableList<CoolerForCaseApiResponse> = mutableListOf(),
    @PropertyName("cooler_for_cpu")
    var coolerForCpu: CoolerForCpuApiResponse? = null,
    @PropertyName("case")
    var case: CaseApiResponse? = null,
    @PropertyName("monitor_list")
    var monitorList: MutableList<MonitorApiResponse> = mutableListOf(),
    @PropertyName("hard_drive_list")
    var hardDriveList: MutableList<HardDriveApiResponse> = mutableListOf(),
    @PropertyName("ssd_list")
    var ssdList: MutableList<SsdApiResponse> = mutableListOf(),
    @PropertyName("user_owner")
    var userOwner: UserApiResponse? = null,
    @PropertyName("is_favorite")
    var isFavorite: Boolean = false
)
   /* fun getListAccessoryFromConfiguration(configurationElementList: Class<out AccessoryApiResponse>): List<AccessoryApiResponse> {
        when (configurationElementList) {
            VideoCard::class.java -> if (videoCardList.isNotEmpty()) return videoCardList
            SsdApiResponse::class.java -> if (ssdList.isNotEmpty()) return ssdList
            DimmApiResponse::class.java -> if (dimmList.isNotEmpty()) return dimmList
            HardDriveApiResponse::class.java -> if (hardDriveList.isNotEmpty()) return hardDriveList
            SoDimmApiResponse::class.java -> if (soDimmList.isNotEmpty()) return soDimmList
            CoolerForCaseApiResponse::class.java -> if (coolerForCaseList.isNotEmpty()) return coolerForCaseList
            Monitor::class.java -> if (monitorList.isNotEmpty()) return monitorList
        }
        return listOf()
    }

    fun isNotEmptyAccessoryInConfiguration(configurationElementList: List<Class<out AccessoryApiResponse>>): Boolean {
        for (element in configurationElementList) {
            when (element) {
                Cpu::class.java -> if (cpu!!._idAccessory != "") return true
                Motherboard::class.java -> if (motherboard!!._idAccessory != "") return true
                PowerSupplyUnit::class.java -> if (powerSupplyUnit!!._idAccessory != "") return true
                SoundCard::class.java -> if (soundCard!!._idAccessory != "") return true
                CaseApiResponse::class.java -> if (case!!._idAccessory != "") return true
                CoolerForCpuApiResponse::class.java -> if (coolerForCpu!!._idAccessory != "" || coolerForCaseList.isNotEmpty()) return true
                VideoCard::class.java -> if (videoCardList.isNotEmpty()) return true
                SsdApiResponse::class.java -> if (ssdList.isNotEmpty() || hardDriveList.isNotEmpty()) return true
                HardDriveApiResponse::class.java -> if (hardDriveList.isNotEmpty() || ssdList.isNotEmpty()) return true
                DimmApiResponse::class.java -> if (dimmList.isNotEmpty() || soDimmList.isNotEmpty()) return true
                SoDimmApiResponse::class.java -> if (dimmList.isNotEmpty() || soDimmList.isNotEmpty()) return true
                CoolerForCaseApiResponse::class.java -> if (coolerForCaseList.isNotEmpty() || coolerForCpu!!._idAccessory != "") return true
                Monitor::class.java -> if (monitorList.isNotEmpty()) return true
            }
        }
        return false
    }

    fun checkAccessoryInConfiguration(configurationElementList: List<Class<out AccessoryApiResponse>>): Boolean {
        for (element in configurationElementList) {
            when (element) {
                Cpu::class.java -> if (cpu != null) return true
                Motherboard::class.java -> if (motherboard != null) return true
                PowerSupplyUnit::class.java -> if (powerSupplyUnit != null) return true
                SoundCard::class.java -> if (soundCard != null && soundCard!!._idAccessory != "") return true
                CaseApiResponse::class.java -> if (case != null) return true
                VideoCard::class.java -> if (videoCardList.isNotEmpty()) return true
                SsdApiResponse::class.java -> if (ssdList.isNotEmpty()) return true
                HardDriveApiResponse::class.java -> if (hardDriveList.isNotEmpty()) return true
                DimmApiResponse::class.java -> if (dimmList.isNotEmpty()) return true
                SoDimmApiResponse::class.java -> if (soDimmList.isNotEmpty()) return true
                CoolerForCaseApiResponse::class.java -> if (coolerForCaseList.isNotEmpty()) return true
                CoolerForCpuApiResponse::class.java -> if (coolerForCpu != null) return true
                Monitor::class.java -> if (monitorList.isNotEmpty()) return true
            }
        }
        return false
    }

    fun getAccessoryFromConfiguration(configurationElementList: Class<out AccessoryApiResponse>): AccessoryApiResponse {
        when (configurationElementList) {
            Cpu::class.java -> if (cpu != null) return cpu!!
            Motherboard::class.java -> if (motherboard != null) return motherboard!!
            PowerSupplyUnit::class.java -> if (powerSupplyUnit != null) return powerSupplyUnit!!
            SoundCard::class.java -> if (soundCard != null && soundCard!!._idAccessory != "") return soundCard!!
            CaseApiResponse::class.java -> if (case != null) return case!!
            CoolerForCpuApiResponse::class.java -> if (coolerForCpu != null) return coolerForCpu!!
            VideoCard::class.java -> if (videoCardList.isNotEmpty()) {
                for (videoCard in videoCardList) {
                    return videoCard
                }
            }

            SsdApiResponse::class.java -> if (ssdList.isNotEmpty()) {
                for (ssd in ssdList) {
                    return ssd
                }
            }

            HardDriveApiResponse::class.java -> if (hardDriveList.isNotEmpty()) {
                for (hardDrive in hardDriveList) {
                    return hardDrive
                }
            }

            SoDimmApiResponse::class.java -> if (soDimmList.isNotEmpty()) {
                for (soDimm in soDimmList) {
                    return soDimm
                }
            }

            CoolerForCaseApiResponse::class.java -> if (coolerForCaseList.isNotEmpty()) {
                for (coolerForCase in coolerForCaseList) {
                    return coolerForCase
                }
            }

            Monitor::class.java -> if (monitorList.isNotEmpty()) {
                for (monitor in monitorList) {
                    return monitor
                }
            }
        }
        return AccessoryApiResponse(_categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD)
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
        if (checkingRamMotherboardCompatibility().isError.value) {
            return checkingRamMotherboardCompatibility()
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
        for (slotsForVideoCardCount in motherboard!!._allSlots) {
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

    private fun checkingRamMotherboardCompatibility(): ConfigurationError {

        if (dimmList.isNotEmpty() && (motherboard!!._supportedMemoryFormFactor != "Dimm")) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram))
            )
        }
        if (soDimmList.isNotEmpty() && (motherboard!!._supportedMemoryFormFactor != "SoDimm")) {
            return ConfigurationError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(AppResources.getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram))
            )
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
        name = this.nameConfiguration,
        isFavorite = this.isFavorite,
        cpuId = this.cpu!!._idAccessory,
        motherboardId = this.motherboard!!._idAccessory,
        powerSupplyUnitId = this.powerSupplyUnit!!._idAccessory,
        dimmIdsList = this.dimmList.map { it._idAccessory }.toMutableList(),
        soDimmIdsList = this.soDimmList.map { it._idAccessory }.toMutableList(),
        soundCardId = if (this.soundCard == null) {
            ""
        } else {
            this.soundCard!!._idAccessory
        },
        videoCardIdsList = this.videoCardList.map { it._idAccessory }.toMutableList(),
        coolerForCaseIdsList = this.coolerForCaseList.map { it._idAccessory }.toMutableList(),
        coolerForCpuId = this.coolerForCpu!!._idAccessory,
        caseId = this.case!!._idAccessory,
        monitorIdsList = this.monitorList.map { it._idAccessory }.toMutableList(),
        hardDriveIdsList = this.hardDriveList.map { it._idAccessory }.toMutableList(),
        ssdIdsList = this.ssdList.map { it._idAccessory }.toMutableList()
    )
}*/


