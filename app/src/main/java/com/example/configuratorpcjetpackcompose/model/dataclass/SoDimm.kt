package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Ram
import com.google.firebase.firestore.PropertyName

data class SoDimm(
    @PropertyName("supply_voltage")
    var _supplyVoltage: Int = 0,
    @PropertyName("radiator")
    var _radiator: Boolean = false,
) : Ram() {
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