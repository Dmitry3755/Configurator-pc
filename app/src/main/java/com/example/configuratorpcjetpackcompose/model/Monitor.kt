package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class Monitor(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("frequency_maximum_resolution")
    val _frequencyAtMaximumResolution: Int =0,
    @PropertyName("maximum_resolution")
    val _maximumResolution: String ="",
    @PropertyName("screen_diagonal")
    val _screenDiagonal: Int =0,
    @PropertyName("matrix_manufacturing_technology")
    val _matrixManufacturingTechnology: String ="",
    @PropertyName("curved_screen")
    val _curvedScreen: Boolean = false,
    @PropertyName("aspect_ratio")
    val _aspectRatio: String ="",
    @PropertyName("hdmi")
    val _hdmi: Boolean = false,
    @PropertyName("hdr_support")
    val _hdrSupport: String ="",
    @PropertyName("dynamic_screen_refresh_technology")
    val _dynamicScreenRefreshTechnology: String ="",
    @PropertyName("display_port_connector")
    val _displayPortConnector: Boolean = false
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.DISPLAY
)
{
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