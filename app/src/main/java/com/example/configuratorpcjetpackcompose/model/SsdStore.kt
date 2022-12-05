package com.example.configuratorpcjetpackcompose.model

data class SsdStore(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val storageCapacity : Int,
    val type: String,
    val connectionConnector : String,
    val maximumRecordingResource : Double,
    val maximumSequentialReadSpeed : Int,
    val dramBuffer : Boolean,
    val maximumSequentialWriteSpeed : Int,
    val numberOfBitsPerCell: String,
    val memoryStructure : String,
    val thickness: Double,
    val dwpd : Double
) : DataStorage(
    nameDataStorage = name,
    priceDataStorage = price,
    descriptionDataStorage = description,
    manufacturerDataStorage = manufacturer,
    thicknessDataStorage = thickness,
    memoryCapacity = storageCapacity
)