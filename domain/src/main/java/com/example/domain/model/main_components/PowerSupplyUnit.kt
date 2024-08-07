package com.example.domain.model.main_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class PowerSupplyUnit(
    var manufacturer: String = "",
    var powerCapacity: Int = 0,
    var certificate80Plus: String = "",
    var detachableCables: String = "",
    var formFactor: String = "",
    var connectorsForVideoCard: String = "",
    var connectorsForCpu: String = "",
    var coolingSystem: String = "",
    var powerFactorCorrector: String = "",
    var typeOfIllumination: String = "",
    var pin15SataConnectorsCounts: Int = 0,
) : Accessory(
    category = CategoryAccessoryEnum.POWER_SUPPLY_UNIT,
)