package com.example.configuratorpcjetpackcompose.model

data class PowerSupplyUnit(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val powerCapacity: Int,
    val certificate80Plus: String,
    val detachableCables: String,
    val formFactor: String,
    val connectorsForVideoCard: String,
    val connectorsForCpu: String,
    val coolingSystem: String,
    val powerFactorCorrector: String,
    val typeOfIllumination: String,
    val pin15SataConnectorsCounts: Int
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.POWER_SUPPLY_UNIT
)