package com.example.configuratorpcjetpackcompose.model

data class Cpu(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val socket: String,
    val family: String,
    val productiveCoresCount: Int,
    val integratedGraphicsCore: Boolean,
    val releaseYear: Int,
    val memoryType: String,
    val baseFrequency: Double,
    val heatDissipation: Int,
    val technicalProcess: String,
    val pinConnector : String,
    val maximumSupportedMemoryCapacity : Int
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR
)
