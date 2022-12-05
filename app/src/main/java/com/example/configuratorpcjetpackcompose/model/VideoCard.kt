package com.example.configuratorpcjetpackcompose.model

data class VideoCard(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val graphicsProcessor: String,
    val videoMemoryCapacity: Int,
    val gpuManufacturer: String,
    val typeOfMemory: String,
    val memoryBusBitRate: Int,
    val connectionInterface: String,
    val typeAndNumberOfInstalledFans: String,
    val lhr: Boolean,
    val monitorsConnectedAtTheSameTimeCount: Int,
    val length: Int,
    val energyConsumptionMax: Int
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD
)
