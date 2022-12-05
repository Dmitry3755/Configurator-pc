package com.example.configuratorpcjetpackcompose.model

data class Motherboard(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val socket: String,
    val chipset: String,
    val memorySlotsCount: Int,
    val forProcesses: String,
    val typeOfSupportedMemory: String,
    val builtInWiFiAdapter: String,
    val pciExpressVersion: Int,
    val m2ConnectorsCount: Int,
    val formFactor: String,
    val energyConsumptionMax : Int,
    val memoryFrequencyMax : Int
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.MOTHERBOARD
)