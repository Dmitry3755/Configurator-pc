package com.example.configuratorpcjetpackcompose.model

data class HardDrive(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val memoryCapacity: Int,
    val purpose: String,
    val spindleRotationSpeed: Int,
    val recordingTechnology: String,
    val cacheMemorySize: Int,
    val optimizationForRaidArrays: Boolean,
    val withHeliumFilling: Boolean,
    val noiseLevelDuringOperation: Int,
    val numberOfPositioningParkingCycles: Int,
    val thickness: Double
) : DataStorage(
    nameDataStorage = name,
    priceDataStorage = price,
    descriptionDataStorage = description,
    manufacturerDataStorage = manufacturer,
    thicknessDataStorage = thickness,
    memoryCapacity = memoryCapacity
)