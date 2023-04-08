package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class SoDimm(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("memory_type")
    val _memoryType: String ="",
    @PropertyName("memory_module_capacity")
    val _memoryModuleCapacity: Int =0,
    @PropertyName("frequency")
    val _frequency: Int =0,
    @PropertyName("supply_voltage")
    val _supplyVoltage: Int =0,
    @PropertyName("cas_latency")
    val _casLatency: Double =0.0,
    @PropertyName("radiator")
    val _radiator: Boolean = false
) : Ram(
    nameRam = _name,
    priceRam = _price,
    descriptionRam = _description,
    manufacturerRam = _manufacturer,
    memoryTypeRam = _memoryType,
    memoryModuleCapacityRam = _memoryModuleCapacity,
    frequencyRam = _frequency,
    casLatencyRam = _casLatency
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