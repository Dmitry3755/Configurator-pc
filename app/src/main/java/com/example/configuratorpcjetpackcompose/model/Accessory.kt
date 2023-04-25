package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

open class Accessory(
    var _idAccessory: String = "",
    @PropertyName("name")
    var _nameAccessory: String = "",
    @PropertyName("price")
    var _priceAccessory: Double  = 0.0,
    @PropertyName("description")
    var _descriptionAccessory: String ="",
    val _categoryAccessoryEnum: CategoryAccessoryEnum,
    @PropertyName("uri")
    var _uriAccessory: String = ""
) {
    var name: String
        get() = _nameAccessory
        set(value) {
            _nameAccessory = value
        }
    var price: Double
        get() = _priceAccessory
        set(value) {
            _priceAccessory = value
        }
    var description: String
        get() = _descriptionAccessory
        set(value) {
            _descriptionAccessory = value
        }
    var uri: String
        get() = _uriAccessory
        set(value) {
            _uriAccessory = value
        }
}