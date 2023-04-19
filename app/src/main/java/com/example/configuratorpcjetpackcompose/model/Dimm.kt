package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class Dimm(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("memory_type")
    val _memoryType: String ="",
    @PropertyName("memory_module_capacity")
    val _memoryModuleCapacity: Int =0,
    @PropertyName("clock_frequency")
    val _clockFrequency: Int =0,
    @PropertyName("presence_radiator")
    val _thePresenceOfARadiator: Boolean = false,
    @PropertyName("illumination_board_elements")
    val _illuminationOfBoardElements: String ="",
    @PropertyName("cas_latency")
    val _casLatency: Double =0.0,
    @PropertyName("ecc_memory")
    val _eccMemory: Boolean = false,
    @PropertyName("server_memory")
    val _serverMemory: Boolean = false,
    @PropertyName("uri")
    val _uri: String = ""
) : Ram(
    nameRam = _name,
    priceRam = _price,
    descriptionRam = _description,
    manufacturerRam = _manufacturer,
    memoryTypeRam = _memoryType,
    memoryModuleCapacityRam = _memoryModuleCapacity,
    frequencyRam = _clockFrequency,
    casLatencyRam = _casLatency,
    uriRam = _uri
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