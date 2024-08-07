package com.example.data.entities.main_components.ram

import com.google.firebase.firestore.PropertyName

data class SoDimmApiResponse(
    @JvmField @PropertyName("supply_voltage")
    var _supplyVoltage: Int = 0,
    @JvmField @PropertyName("radiator")
    var _radiator: Boolean = false,
) : RamApiResponse() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        soDimm: SoDimmApiResponse
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