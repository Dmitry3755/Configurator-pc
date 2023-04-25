package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class VideoCard(
    @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @PropertyName("graphics_processor")
    var _graphicsProcessor: String = "",
    @PropertyName("video_memory_capacity")
    var _videoMemoryCapacity: Int = 0,
    @PropertyName("gpu_manufacturer")
    var _gpuManufacturer: String = "",
    @PropertyName("type_memory")
    var _typeOfMemory: String = "",
    @PropertyName("memory_bus_bit_rate")
    var _memoryBusBitRate: Int = 0,
    @PropertyName("connection_interface")
    var _connectionInterface: String = "",
    @PropertyName("type_number_installed_fans")
    var _typeAndNumberOfInstalledFans: String = "",
    @PropertyName("lhr")
    var _lhr: Boolean = false,
    @PropertyName("monitors_connected_same_time_count")
    var _monitorsConnectedAtTheSameTimeCount: Int = 0,
    @PropertyName("length")
    var _length: Int = 0,
    @PropertyName("energy_consumption_max")
    var _energyConsumptionMax: Int = 0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD,
) {
    var manufacturer: String
        get() = _manufacturer
        set(value) {
            _manufacturer = value
        }
    var graphicsProcessor: String
        get() = _graphicsProcessor
        set(value) {
            _graphicsProcessor = value
        }
    var videoMemoryCapacity: Int
        get() = _videoMemoryCapacity
        set(value) {
            _videoMemoryCapacity = value
        }
    var gpuManufacturer: String
        get() = _gpuManufacturer
        set(value) {
            _gpuManufacturer = value
        }
    var typeOfMemory: String
        get() = _typeOfMemory
        set(value) {
            _typeOfMemory = value
        }
    var memoryBusBitRate: Int
        get() = _memoryBusBitRate
        set(value) {
            _memoryBusBitRate = value
        }
    var connectionInterface: String
        get() = _connectionInterface
        set(value) {
            _connectionInterface = value
        }
    var typeAndNumberOfInstalledFans: String
        get() = _typeAndNumberOfInstalledFans
        set(value) {
            _typeAndNumberOfInstalledFans = value
        }
    var lhr: Boolean
        get() = _lhr
        set(value) {
            _lhr = value
        }
    var monitorsConnectedAtTheSameTimeCount: Int
        get() = _monitorsConnectedAtTheSameTimeCount
        set(value) {
            _monitorsConnectedAtTheSameTimeCount = value
        }
    var length: Int
        get() = _length
        set(value) {
            _length = value
        }
    var energyConsumptionMax: Int
        get() = _energyConsumptionMax
        set(value) {
            _energyConsumptionMax = value
        }
}
