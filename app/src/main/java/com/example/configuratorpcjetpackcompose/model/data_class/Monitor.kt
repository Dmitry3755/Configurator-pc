package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Monitor(
    @JvmField @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("frequency_maximum_resolution")
    var _frequencyAtMaximumResolution: Int = 0,
    @JvmField @PropertyName("maximum_resolution")
    var _maximumResolution: String = "",
    @JvmField @PropertyName("screen_diagonal")
    var _screenDiagonal: Int = 0,
    @JvmField @PropertyName("matrix_manufacturing_technology")
    var _matrixManufacturingTechnology: String = "",
    @JvmField @PropertyName("curved_screen")
    var _curvedScreen: Boolean = false,
    @JvmField @PropertyName("aspect_ratio")
    var _aspectRatio: String = "",
    @JvmField @PropertyName("hdmi")
    var _hdmi: Boolean = false,
    @JvmField @PropertyName("hdr_support")
    var _hdrSupport: String = "",
    @JvmField @PropertyName("dynamic_screen_refresh_technology")
    var _dynamicScreenRefreshTechnology: String = "",
    @JvmField @PropertyName("display_port_connector")
    var _displayPortConnector: Boolean = false,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.DISPLAY,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        monitor: Monitor
    ) : this(
        _manufacturer = monitor._manufacturer,
        _frequencyAtMaximumResolution = monitor._frequencyAtMaximumResolution,
        _maximumResolution = monitor._maximumResolution,
        _screenDiagonal = monitor._screenDiagonal,
        _matrixManufacturingTechnology = monitor._matrixManufacturingTechnology,
        _curvedScreen = monitor._curvedScreen,
        _aspectRatio = monitor._aspectRatio,
        _hdmi = monitor._hdmi,
        _hdrSupport = monitor._hdrSupport,
        _dynamicScreenRefreshTechnology = monitor._dynamicScreenRefreshTechnology,
        _displayPortConnector = monitor._displayPortConnector
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

    var manufacturer: String
        get() = _manufacturer
        set(value) {
            _manufacturer = value
        }
    var frequencyAtMaximumResolution: Int
        get() = _frequencyAtMaximumResolution
        set(value) {
            _frequencyAtMaximumResolution = value
        }
    var maximumResolution: String
        get() = _maximumResolution
        set(value) {
            _maximumResolution = value
        }
    var screenDiagonal: Int
        get() = _screenDiagonal
        set(value) {
            _screenDiagonal = value
        }
    var matrixManufacturingTechnology: String
        get() = _matrixManufacturingTechnology
        set(value) {
            _matrixManufacturingTechnology = value
        }
    var curvedScreen: Boolean
        get() = _curvedScreen
        set(value) {
            _curvedScreen = value
        }
    var aspectRatio: String
        get() = _aspectRatio
        set(value) {
            _aspectRatio = value
        }
    var hdmi: Boolean
        get() = _hdmi
        set(value) {
            _hdmi = value
        }
    var hdrSupport: String
        get() = _hdrSupport
        set(value) {
            _hdrSupport = value
        }
    var dynamicScreenRefreshTechnology: String
        get() = _dynamicScreenRefreshTechnology
        set(value) {
            _dynamicScreenRefreshTechnology = value
        }
    var displayPortConnector: Boolean
        get() = _displayPortConnector
        set(value) {
            _displayPortConnector = value
        }
}