package com.example.domain.model.main_components.cooling.air_cooling

data class CoolerForCpu(
    val typeOfConstruction: String = "",
    var heatPipesCount: Int = 0,
    var connectorForConnectingFans: String = "",
    var adjustingTheRotationSpeed: String = "",
    var typeOfBacklightPowerConnector: String = "",
    var socket: List<String> = listOf(""),
    var powerDissipation: Int = 0,
    var height: Double = 0.0,
    var maximumNoiseLevel: Double = 0.0,
) : Cooler()