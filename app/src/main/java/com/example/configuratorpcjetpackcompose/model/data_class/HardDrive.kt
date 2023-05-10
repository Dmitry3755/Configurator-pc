package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.DataStorage
import com.google.firebase.firestore.PropertyName

data class HardDrive(
    @JvmField @PropertyName("purpose")
    var _purpose: String = "",
    @JvmField @PropertyName("spindle_rotation_speed")
    var _spindleRotationSpeed: Int = 0,
    @JvmField @PropertyName("recording_technology")
    var _recordingTechnology: String = "",
    @JvmField @PropertyName("cache_memory_size")
    var _cacheMemorySize: Int = 0,
    @JvmField @PropertyName("optimization_for_raid_arrays")
    var _optimizationForRaidArrays: Boolean = false,
    @JvmField @PropertyName("with_helium_filling")
    var _withHeliumFilling: Boolean = false,
    @JvmField @PropertyName("noise_level_during_operation")
    var _noiseLevelDuringOperation: Int = 0,
    @JvmField @PropertyName("number_positioning_parking_cycles")
    var _numberOfPositioningParkingCycles: Int = 0,
) : DataStorage() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        hardDrive: HardDrive
    ) : this(
        _purpose = hardDrive._purpose,
        _spindleRotationSpeed = hardDrive._spindleRotationSpeed,
        _recordingTechnology = hardDrive._recordingTechnology,
        _cacheMemorySize = hardDrive._cacheMemorySize,
        _optimizationForRaidArrays = hardDrive._optimizationForRaidArrays,
        _withHeliumFilling = hardDrive._withHeliumFilling,
        _noiseLevelDuringOperation = hardDrive._noiseLevelDuringOperation,
        _numberOfPositioningParkingCycles = hardDrive._numberOfPositioningParkingCycles
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

    var purpose: String
        get() = _purpose
        set(value) {
            _purpose = value
        }
    var spindleRotationSpeed: Int
        get() = _spindleRotationSpeed
        set(value) {
            _spindleRotationSpeed = value
        }
    var recordingTechnology: String
        get() = _recordingTechnology
        set(value) {
            _recordingTechnology = value
        }
    var cacheMemorySize: Int
        get() = _cacheMemorySize
        set(value) {
            _cacheMemorySize = value
        }
    var optimizationForRaidArrays: Boolean
        get() = _optimizationForRaidArrays
        set(value) {
            _optimizationForRaidArrays = value
        }
    var withHeliumFilling: Boolean
        get() = _withHeliumFilling
        set(value) {
            _withHeliumFilling = value
        }
    var noiseLevelDuringOperation: Int
        get() = _noiseLevelDuringOperation
        set(value) {
            _noiseLevelDuringOperation = value
        }
    var numberOfPositioningParkingCycles: Int
        get() = _numberOfPositioningParkingCycles
        set(value) {
            _numberOfPositioningParkingCycles = value
        }
}