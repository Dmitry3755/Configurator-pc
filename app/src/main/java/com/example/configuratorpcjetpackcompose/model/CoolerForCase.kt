package com.example.configuratorpcjetpackcompose.model

data class CoolerForCase(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val fanSize: Int,
    val typeOfIllumination: String,
    val typeOfPowerConnector: String,
    val maximumNoiseLevel: Double,
    val speedAdjustment: String,
    val typeOfBearing: String,
    val maximumRotationSpeed: Int,
    val hubControllerIncluded: Boolean,
    val typeOfBacklightPowerConnector: String
) : Cooler(
    nameCooler = name,
    priceCooler = price,
    descriptionCooler = description,
    manufacturerCooler = manufacturer,
    typeOfIlluminationCooler = typeOfBearing
)