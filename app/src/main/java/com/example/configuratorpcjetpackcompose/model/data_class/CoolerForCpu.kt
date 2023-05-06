package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Cooler
import com.google.firebase.firestore.PropertyName

data class CoolerForCpu(
    @PropertyName("type_construction")
    val _typeOfConstruction: String = "",
    @PropertyName("heat_pipes_count")
    var _heatPipesCount: Int = 0,
    @PropertyName("connector_connecting_fans")
    var _connectorForConnectingFans: String = "",
    @PropertyName("adjusting_rotation_speed")
    var _adjustingTheRotationSpeed: String = "",
    @PropertyName("type_backlight_power_connector")
    var _typeOfBacklightPowerConnector: String = "",
    @PropertyName("socket")
    var _socket: List<String> = listOf(""),
    @PropertyName("power_dissipation")
    var _powerDissipation: Int = 0,
    @PropertyName("height")
    var _height: Double = 0.0,
    @PropertyName("maximum_noise_level")
    var _maximumNoiseLevel: Double = 0.0,
) : Cooler() {

    var heatPipesCount: Int
        get() = _heatPipesCount
        set(value) {
            _heatPipesCount = value
        }
    var connectorForConnectingFans: String
        get() = _connectorForConnectingFans
        set(value) {
            _connectorForConnectingFans = value
        }
    var adjustingTheRotationSpeed: String
        get() = _adjustingTheRotationSpeed
        set(value) {
            _adjustingTheRotationSpeed = value
        }
    var typeOfBacklightPowerConnector: String
        get() = _typeOfBacklightPowerConnector
        set(value) {
            _typeOfBacklightPowerConnector = value
        }
    var socket:  List<String>
        get() = _socket
        set(value) {
            _socket = value
        }
    var powerDissipation: Int
        get() = _powerDissipation
        set(value) {
            _powerDissipation = value
        }
    var height: Double
        get() = _height
        set(value) {
            _height = value
        }
    var maximumNoiseLevel: Double
        get() = _maximumNoiseLevel
        set(value) {
            _maximumNoiseLevel = value
        }
}