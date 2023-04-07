package com.example.configuratorpcjetpackcompose.model

import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError

data class Configuration(
    var cpu: Cpu? = null,
    var motherboard: Motherboard? = null,
    var dimmRamList: List<DimmRam> = emptyList(),
    var soDimmRamList: List<SoDimmRam> = emptyList(),
    var powerSupplyUnit: PowerSupplyUnit? = null,
    var soundCard: SoundCard? = null,
    var videoCardList: List<VideoCard> = emptyList(),
    var coolerForCaseList: List<CoolerForCase> = emptyList(),
    var coolerForCpu: CoolerForCpu? = null,
    var case: Case? = null,
    var monitorList: List<Monitor> = emptyList(),
    var hardDriveList: List<HardDrive> = emptyList(),
    var ssdList: List<Ssd> = emptyList(),
    var userOwner: User
) {
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
}