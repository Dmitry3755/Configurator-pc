package com.example.configuratorpcjetpackcompose.model

data class CoolerForCpu(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val typeOfConstruction: String,
    val heatPipesCount: Int,
    val connectorForConnectingFans: String,
    val adjustingTheRotationSpeed: String,
    val typeOfIllumination: String,
    val typeOfBacklightPowerConnector: String,
    val socket: List<String>,
    val powerDissipation: Int,
    val height: Double,
    val maximumNoiseLevel: Double
) : Cooler(
    nameCooler = name,
    priceCooler = price,
    descriptionCooler = description,
    manufacturerCooler = manufacturer,
    typeOfIlluminationCooler = typeOfIllumination
)