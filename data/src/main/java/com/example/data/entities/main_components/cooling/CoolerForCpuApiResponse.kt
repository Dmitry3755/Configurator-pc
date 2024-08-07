package com.example.data.entities.main_components.cooling

import com.google.firebase.firestore.PropertyName

data class CoolerForCpuApiResponse(
    @JvmField @PropertyName("type_construction")
    val _typeOfConstruction: String = "",
    @JvmField @PropertyName("heat_pipes_count")
    var _heatPipesCount: Int = 0,
    @JvmField @PropertyName("connector_connecting_fans")
    var _connectorForConnectingFans: String = "",
    @JvmField @PropertyName("adjusting_rotation_speed")
    var _adjustingTheRotationSpeed: String = "",
    @JvmField @PropertyName("type_backlight_power_connector")
    var _typeOfBacklightPowerConnector: String = "",
    @JvmField @PropertyName("socket")
    var _socket: List<String> = listOf(""),
    @JvmField @PropertyName("power_dissipation")
    var _powerDissipation: Int = 0,
    @JvmField @PropertyName("height")
    var _height: Double = 0.0,
    @JvmField @PropertyName("maximum_noise_level")
    var _maximumNoiseLevel: Double = 0.0,
) : CoolerApiResponse() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        coolerForCpu: CoolerForCpuApiResponse
    ) : this(
        _typeOfConstruction = coolerForCpu._typeOfConstruction,
        _heatPipesCount = coolerForCpu._heatPipesCount,
        _connectorForConnectingFans = coolerForCpu._connectorForConnectingFans,
        _adjustingTheRotationSpeed = coolerForCpu._adjustingTheRotationSpeed,
        _typeOfBacklightPowerConnector = coolerForCpu._typeOfBacklightPowerConnector,
        _socket = coolerForCpu._socket,
        _powerDissipation = coolerForCpu._powerDissipation,
        _height = coolerForCpu._height,
        _maximumNoiseLevel = coolerForCpu._maximumNoiseLevel
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }


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
    var socket: List<String>
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