package com.example.configuratorpcjetpackcompose.model

import android.content.res.Resources
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.utils.DataResult

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
    var ssdStoreList: List<SsdStore> = emptyList(),
    var userOwner: User
) {
    fun checkingCompatibility() {
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
        var energy = 0

        checkingTheRequiredComponents()
        energy = calcEnergy()

        if (cpu?.socketCpu != motherboard?.socketMotherboard) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_processor_socket)
                )
            )
        }
        if (motherboard?.formFactorMotherboard != case?.formFactorOfCompatibleBoardsCase) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_case_does_not_support_form_factor_of_motherboard)
                )
            )
        }
        if (coolerForCpu?.socketCoolerForCpu != motherboard?.socketMotherboard) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_cpu_cooler_does_not_support_motherboard_socket)
                )
            )
        }
        for (ram in dimmRamList) {
            if (motherboard?.typeOfSupportedMemoryMotherboard != ram.memoryTypeDimmRam) {
                DataResult.Error(
                    exception = Exception(
                        Resources.getSystem()
                            .getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram)
                    )
                )
            }
        }
        for (ram in soDimmRamList) {
            if (motherboard?.typeOfSupportedMemoryMotherboard != ram.memoryTypeSoDimmRam) {
                DataResult.Error(
                    exception = Exception(
                        Resources.getSystem()
                            .getString(R.string.error_configuration_motherboard_does_not_support_type_of_ram)
                    )
                )
            }
        }
        if (powerSupplyUnit?.connectorsForCpuPowerSupplyUnit != cpu?.pinConnectorCpu) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_pin_cpu_is_not_compatible)
                )
            )
        }
        for (videoCard in videoCardList) {
            if (videoCard.lengthVideoCard > case?.lengthMaxOfVideoCardCase!!) {
                DataResult.Error(
                    exception = Exception(
                        Resources.getSystem()
                            .getString(R.string.error_configuration_case_does_not_support_size_of_video_card)
                    )
                )
            }
            energy += videoCard.energyConsumptionMaxVideoCard
            if (energy >= powerSupplyUnit?.powerCapacityPowerSupplyUnit!!) {
                DataResult.Error(
                    exception = Exception(
                        Resources.getSystem()
                            .getString(R.string.error_configuration_case_does_not_support_size_of_video_card)
                    )
                )
            }
        }
    }

    private fun calcEnergy(): Int {
        var energy = 0
        energy = cpu?.heatDissipationCpu!! + motherboard?.energyConsumptionMaxMotherboard!! + 50
        return energy
    }

    private fun checkingTheRequiredComponents() {
        if (cpu == null) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem().getString(R.string.error_configuration_cpu_is_empty)
                )
            )
        }
        if (motherboard == null) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem().getString(R.string.error_configuration_cpu_is_empty)
                )
            )
        }
        if (case == null) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem().getString(R.string.error_configuration_case_is_empty)
                )
            )
        }
        if (coolerForCpu == null) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_cooler_for_cpu_is_empty)
                )
            )
        }
        if ((dimmRamList.isEmpty()) && (soDimmRamList.isEmpty())) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem().getString(R.string.error_configuration_ram_is_empty)
                )
            )
        }
        if ((ssdStoreList.isEmpty()) && (hardDriveList.isEmpty())) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_data_storage_is_empty)
                )
            )
        }
        if (powerSupplyUnit == null) {
            DataResult.Error(
                exception = Exception(
                    Resources.getSystem()
                        .getString(R.string.error_configuration_power_supply_unit_is_empty)
                )
            )
        }
        if (videoCardList.isEmpty()) {
            if (cpu?.integratedGraphicsCoreCpu == false) {
                DataResult.Error(
                    exception = Exception(
                        Resources.getSystem()
                            .getString(R.string.error_configuration_cpu_without_integrated_graphics_core)
                    )
                )
            }
        }
    }
}