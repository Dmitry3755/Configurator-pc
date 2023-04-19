package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class VideoCard(
    @PropertyName("name")
    var _name: String = "",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String = "",
    @PropertyName("graphics_processor")
    val _graphicsProcessor: String = "",
    @PropertyName("video_memory_capacity")
    val _videoMemoryCapacity: Int = 0,
    @PropertyName("gpu_manufacturer")
    val _gpuManufacturer: String = "",
    @PropertyName("type_memory")
    val _typeOfMemory: String = "",
    @PropertyName("memory_bus_bit_rate")
    val _memoryBusBitRate: Int = 0,
    @PropertyName("connection_interface")
    val _connectionInterface: String = "",
    @PropertyName("type_number_installed_fans")
    val _typeAndNumberOfInstalledFans: String = "",
    @PropertyName("lhr")
    val _lhr: Boolean = false,
    @PropertyName("monitors_connected_same_time_count")
    val _monitorsConnectedAtTheSameTimeCount: Int = 0,
    @PropertyName("length")
    val _length: Int = 0,
    @PropertyName("energy_consumption_max")
    val _energyConsumptionMax: Int = 0,
    @PropertyName("uri")
    val _uri: String = ""
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD,
    uriAccessory = _uri
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
