package com.example.configuratorpcjetpackcompose.model

data class DimmRam(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val memoryType: String,
    val memoryModuleCapacity: Int,
    val clockFrequency: Int,
    val thePresenceOfARadiator: Boolean,
    val illuminationOfBoardElements: String,
    val casLatency: Double,
    val eccMemory: Boolean,
    val serverMemory: Boolean
) : Ram(
    nameRam = name,
    priceRam = price,
    descriptionRam = description,
    manufacturerRam = manufacturer,
    memoryTypeRam = memoryType,
    memoryModuleCapacityRam = memoryModuleCapacity,
    frequencyRam = clockFrequency,
    casLatencyRam = casLatency
)