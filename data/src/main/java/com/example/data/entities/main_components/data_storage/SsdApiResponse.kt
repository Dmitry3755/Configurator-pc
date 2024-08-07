package com.example.data.entities.main_components.data_storage

import com.google.firebase.firestore.PropertyName

data class SsdApiResponse(
    @JvmField @PropertyName("type")
    var _type: String = "",
    @JvmField @PropertyName("connection_connector")
    var _connectionConnector: String = "",
    @JvmField @PropertyName("maximum_recording_resource")
    var _maximumRecordingResource: Double = 0.0,
    @JvmField @PropertyName("maximum_sequential_read_speed")
    var _maximumSequentialReadSpeed: Int = 0,
    @JvmField @PropertyName("dram_buffer")
    var _dramBuffer: Boolean = false,
    @JvmField @PropertyName("maximum_sequential_write_speed")
    var _maximumSequentialWriteSpeed: Int = 0,
    @JvmField @PropertyName("number_bits_per_cell")
    var _numberOfBitsPerCell: String = "",
    @JvmField @PropertyName("memory_structure")
    var _memoryStructure: String = "",
    @JvmField @PropertyName("dwpd")
    var _dwpd: Double = 0.0,
) : DataStorageApiResponse() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        ssd: SsdApiResponse
    ) : this(
        _type = ssd._type,
        _connectionConnector = ssd._connectionConnector,
        _maximumRecordingResource = ssd._maximumRecordingResource,
        _maximumSequentialReadSpeed = ssd._maximumSequentialReadSpeed,
        _dramBuffer = ssd._dramBuffer,
        _maximumSequentialWriteSpeed = ssd._maximumSequentialWriteSpeed,
        _numberOfBitsPerCell = ssd._numberOfBitsPerCell,
        _memoryStructure = ssd._memoryStructure,
        _dwpd = ssd._dwpd
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

    var type: String
        get() = _type
        set(value) {
            _type = value
        }
    var connectionConnector: String
        get() = _connectionConnector
        set(value) {
            _connectionConnector = value
        }
    var maximumRecordingResource: Double
        get() = _maximumRecordingResource
        set(value) {
            _maximumRecordingResource = value
        }
    var maximumSequentialReadSpeed: Int
        get() = _maximumSequentialReadSpeed
        set(value) {
            _maximumSequentialReadSpeed = value
        }
    var dramBuffer: Boolean
        get() = _dramBuffer
        set(value) {
            _dramBuffer = value
        }
    var maximumSequentialWriteSpeed: Int
        get() = _maximumSequentialWriteSpeed
        set(value) {
            _maximumSequentialWriteSpeed = value
        }
    var numberOfBitsPerCell: String
        get() = _numberOfBitsPerCell
        set(value) {
            _numberOfBitsPerCell = value
        }
    var memoryStructure: String
        get() = _memoryStructure
        set(value) {
            _memoryStructure = value
        }
    var dwpd: Double
        get() = _dwpd
        set(value) {
            _dwpd = value
        }
}