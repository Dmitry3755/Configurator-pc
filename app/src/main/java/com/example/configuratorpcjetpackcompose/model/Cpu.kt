package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName
import com.google.j2objc.annotations.Property

data class Cpu(
    @PropertyName("name")
    var _name: String = "",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String = "",
    @PropertyName("socket")
    val _socket: String = "",
    @PropertyName("family")
    val _family: String = "",
    @JvmField @PropertyName("productive_cores_count")
    val _productiveCoresCount: Int = 0,
    @JvmField @PropertyName("integrated_graphics_core")
    val _integratedGraphicsCore: Boolean = false,
    @JvmField @PropertyName("release_year")
    val _releaseYear: Int = 0,
    @JvmField @PropertyName("memory_type")
    val _memoryType: String = "",
    @JvmField @PropertyName("base_frequency")
    val _baseFrequency: Double = 0.0,
    @JvmField @PropertyName("heat_dissipation")
    val _heatDissipation: Int = 0,
    @JvmField @PropertyName("technical_process")
    val _technicalProcess: String = "",
    @JvmField @PropertyName("pin_connector")
    val _pinConnector: String = "",
    @JvmField @PropertyName("maximum_supported_memory_capacity")
    val _maximumSupportedMemoryCapacity: Int = 0
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR
) {
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
