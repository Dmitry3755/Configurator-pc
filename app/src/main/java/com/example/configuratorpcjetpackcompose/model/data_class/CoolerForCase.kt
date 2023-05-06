package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Cooler
import com.google.firebase.firestore.PropertyName

data class CoolerForCase(
    @PropertyName("fan_size")
    var _fanSize: String = "",
    @PropertyName("type_power_connector")
    var _typeOfPowerConnector: List<String> = listOf(""),
    @PropertyName("maximum_noise_level")
    var _maximumNoiseLevel: Double = 0.0,
    @PropertyName("speed_adjustment")
    var _speedAdjustment: String = "",
    @PropertyName("type_bearing")
    var _typeOfBearing: String = "",
    @PropertyName("maximum_rotation_speed")
    var _maximumRotationSpeed: Int = 0,
    @PropertyName("hub_controller_included")
    var _hubControllerIncluded: Boolean = false,
    @PropertyName("type_backlight_power_connector")
    var _typeOfBacklightPowerConnector: String = "",
) : Cooler() {
    var fanSize: String
        get() = _fanSize
        set(value) {
            _fanSize = value
        }
    var typeOfPowerConnector: List<String>
        get() = _typeOfPowerConnector
        set(value) {
            _typeOfPowerConnector = value
        }
    var maximumNoiseLevel: Double
        get() = _maximumNoiseLevel
        set(value) {
            _maximumNoiseLevel = value
        }
    var speedAdjustment: String
        get() = _speedAdjustment
        set(value) {
            _speedAdjustment = value
        }
    var typeOfBearing: String
        get() = _typeOfBearing
        set(value) {
            _typeOfBearing = value
        }
    var maximumRotationSpeed: Int
        get() = _maximumRotationSpeed
        set(value) {
            _maximumRotationSpeed = value
        }
    var hubControllerIncluded: Boolean
        get() = _hubControllerIncluded
        set(value) {
            _hubControllerIncluded = value
        }
    var typeOfBacklightPowerConnector: String
        get() = _typeOfBacklightPowerConnector
        set(value) {
            _typeOfBacklightPowerConnector = value
        }
}