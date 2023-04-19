package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class HardDrive(
    @PropertyName("name")
    var _name: String = "",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String = "",
    @PropertyName("memory_capacity")
    val _memoryCapacity: Int = 0,
    @PropertyName("purpose")
    val _purpose: String = "",
    @PropertyName("spindle_rotation_speed")
    val _spindleRotationSpeed: Int = 0,
    @PropertyName("recording_technology")
    val _recordingTechnology: String = "",
    @PropertyName("cache_memory_size")
    val _cacheMemorySize: Int = 0,
    @PropertyName("optimization_for_raid_arrays")
    val _optimizationForRaidArrays: Boolean = false,
    @PropertyName("with_helium_filling")
    val _withHeliumFilling: Boolean = false,
    @PropertyName("noise_level_during_operation")
    val _noiseLevelDuringOperation: Int = 0,
    @PropertyName("number_positioning_parking_cycles")
    val _numberOfPositioningParkingCycles: Int = 0,
    @PropertyName("thickness")
    val _thickness: Double = 0.0,
    @JvmField @PropertyName("uri")
    val _uri: String = ""
) : DataStorage(
    nameDataStorage = _name,
    priceDataStorage = _price,
    descriptionDataStorage = _description,
    manufacturerDataStorage = _manufacturer,
    thicknessDataStorage = _thickness,
    memoryCapacity = _memoryCapacity,
    uriMemory = _uri
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