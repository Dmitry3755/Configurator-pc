package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.DataStorage
import com.google.firebase.firestore.PropertyName

data class Ssd(
    @PropertyName("type")
    var _type: String = "",
    @PropertyName("connection_connector")
    var _connectionConnector: String = "",
    @PropertyName("maximum_recording_resource")
    var _maximumRecordingResource: Double = 0.0,
    @PropertyName("maximum_sequential_read_speed")
    var _maximumSequentialReadSpeed: Int = 0,
    @PropertyName("dram_buffer")
    var _dramBuffer: Boolean = false,
    @PropertyName("maximum_sequential_write_speed")
    var _maximumSequentialWriteSpeed: Int = 0,
    @PropertyName("number_bits_per_cell")
    var _numberOfBitsPerCell: String = "",
    @PropertyName("memory_structure")
    var _memoryStructure: String = "",
    @PropertyName("dwpd")
    var _dwpd: Double = 0.0,
) : DataStorage() {
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