package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class CoolerForCpu(
    @PropertyName("name")
    var _name: String = "",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String = "",
    @PropertyName("type_construction")
    val _typeOfConstruction: String = "",
    @PropertyName("heat_pipes_count")
    val _heatPipesCount: Int = 0,
    @PropertyName("connector_connecting_fans")
    val _connectorForConnectingFans: String = "",
    @PropertyName("adjusting_rotation_speed")
    val _adjustingTheRotationSpeed: String = "",
    @PropertyName("type_illumination")
    val _typeOfIllumination: String = "",
    @PropertyName("type_backlight_power_connector")
    val _typeOfBacklightPowerConnector: String = "",
    @PropertyName("socket")
    val _socket: List<String> = listOf(""),
    @PropertyName("power_dissipation")
    val _powerDissipation: Int = 0,
    @PropertyName("height")
    val _height: Double = 0.0,
    @PropertyName("maximum_noise_level")
    val _maximumNoiseLevel: Double = 0.0
) : Cooler(
    nameCooler = _name,
    priceCooler = _price,
    descriptionCooler = _description,
    manufacturerCooler = _manufacturer,
    typeOfIlluminationCooler = _typeOfIllumination
) {
    var name: String
        get() = _name
        set(value) {
            _name = value
            nameAccessory = value
        }
    var price: Double
        get() = _price
        set(value) {
            _price = value
            priceAccessory = value
        }
}