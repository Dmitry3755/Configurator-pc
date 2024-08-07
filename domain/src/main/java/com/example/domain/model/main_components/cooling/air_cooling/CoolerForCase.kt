package com.example.domain.model.main_components.cooling.air_cooling

data class CoolerForCase(
    var fanSize: String = "",
    var typeOfPowerConnector: List<String> = listOf(""),
    var maximumNoiseLevel: Double = 0.0,
    var speedAdjustment: String = "",
    var typeOfBearing: String = "",
    var maximumRotationSpeed: Int = 0,
    var hubControllerIncluded: Boolean = false,
    var typeOfBacklightPowerConnector: String = "",
) : Cooler()