package com.example.configuratorpcjetpackcompose.model

data class SoDimmRam(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val memoryType: String,
    val memoryModuleCapacity: Int,
    val frequency: Int,
    val supplyVoltage: Int,
    val casLatency: Double,
    val radiator: Boolean
) : Ram(
    nameRam = name,
    priceRam = price,
    descriptionRam = description,
    manufacturerRam = manufacturer,
    memoryTypeRam = memoryType,
    memoryModuleCapacityRam = memoryModuleCapacity,
    frequencyRam = frequency,
    casLatencyRam = casLatency
)