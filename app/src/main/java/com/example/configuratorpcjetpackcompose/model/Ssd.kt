package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class Ssd(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("storage_capacity")
    val _storageCapacity : Int =0,
    @PropertyName("type")
    val _type: String = "",
    @PropertyName("connection_connector")
    val _connectionConnector : String ="",
    @PropertyName("maximum_recording_resource")
    val _maximumRecordingResource : Double =0.0,
    @PropertyName("maximum_sequential_read_speed")
    val _maximumSequentialReadSpeed : Int =0,
    @PropertyName("dram_buffer")
    val _dramBuffer : Boolean = false,
    @PropertyName("maximum_sequential_write_speed")
    val _maximumSequentialWriteSpeed : Int =0,
    @PropertyName("number_bits_per_cell")
    val _numberOfBitsPerCell: String ="",
    @PropertyName("memory_structure")
    val _memoryStructure : String ="",
    @PropertyName("thickness")
    val _thickness: Double = 0.0,
    @PropertyName("dwpd")
    val _dwpd : Double = 0.0
) : DataStorage(
    nameDataStorage = _name,
    priceDataStorage = _price,
    descriptionDataStorage = _description,
    manufacturerDataStorage = _manufacturer,
    thicknessDataStorage = _thickness,
    memoryCapacity = _storageCapacity
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