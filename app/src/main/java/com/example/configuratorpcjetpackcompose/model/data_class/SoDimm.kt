package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Ram
import com.google.firebase.firestore.PropertyName

data class SoDimm(
    @JvmField @PropertyName("supply_voltage")
    var _supplyVoltage: Int = 0,
    @JvmField @PropertyName("radiator")
    var _radiator: Boolean = false,
) : Ram() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        soDimm: SoDimm
    ) : this(
        _supplyVoltage = soDimm._supplyVoltage,
        _radiator = soDimm._radiator
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

    var supplyVoltage: Int
        get() = _supplyVoltage
        set(value) {
            _supplyVoltage = value
        }
    var radiator: Boolean
        get() = _radiator
        set(value) {
            _radiator = value
        }
}