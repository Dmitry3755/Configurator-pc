package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Monitor(
    @PropertyName("manufacturer")
    var _manufacturer: String ="",
    @PropertyName("frequency_maximum_resolution")
    var _frequencyAtMaximumResolution: Int =0,
    @PropertyName("maximum_resolution")
    var _maximumResolution: String ="",
    @PropertyName("screen_diagonal")
    var _screenDiagonal: Int =0,
    @PropertyName("matrix_manufacturing_technology")
    var _matrixManufacturingTechnology: String ="",
    @PropertyName("curved_screen")
    var _curvedScreen: Boolean = false,
    @PropertyName("aspect_ratio")
    var _aspectRatio: String ="",
    @PropertyName("hdmi")
    var _hdmi: Boolean = false,
    @PropertyName("hdr_support")
    var _hdrSupport: String ="",
    @PropertyName("dynamic_screen_refresh_technology")
    var _dynamicScreenRefreshTechnology: String ="",
    @PropertyName("display_port_connector")
    var _displayPortConnector: Boolean = false,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.DISPLAY,
) {
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