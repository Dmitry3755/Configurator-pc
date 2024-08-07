package com.example.domain.model.main_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class Motherboard(
    var manufacturer: String = "",
    var socket: String = "",
    var chipset: String = "",
    var memorySlotsCount: Int = 0,
    var forProcesses: String = "",
    var typeOfSupportedMemory: String = "",
    var builtInWiFiAdapter: String = "",
    var pciExpressVersion: Int = 0,
    var m2ConnectorsCount: Int = 0,
    var formFactor: String = "",
    var energyConsumptionMax: Int = 0,
    var memoryFrequencyMax: Int = 0,
    var allSlots: List<String> = listOf(),
    var supportedMemoryFormFactor: String = ""
) : Accessory(
    category = CategoryAccessoryEnum.MOTHERBOARD,
)