package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class CoolerForCase(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("fan_size")
    val _fanSize: String = "",
    @PropertyName("type_illumination")
    val _typeOfIllumination: String ="",
    @PropertyName("type_power_connector")
    val _typeOfPowerConnector: List<String> = listOf(""),
    @PropertyName("maximum_noise_level")
    val _maximumNoiseLevel: Double = 0.0,
    @PropertyName("speed_adjustment")
    val _speedAdjustment: String ="",
    @PropertyName("type_bearing")
    val _typeOfBearing: String ="",
    @PropertyName("maximum_rotation_speed")
    val _maximumRotationSpeed: Int = 0,
    @PropertyName("hub_controller_included")
    val _hubControllerIncluded: Boolean = false,
    @PropertyName("type_backlight_power_connector")
    val _typeOfBacklightPowerConnector: String =""
) : Cooler(
    nameCooler = _name,
    priceCooler = _price,
    descriptionCooler = _description,
    manufacturerCooler = _manufacturer,
    typeOfIlluminationCooler = _typeOfBearing
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