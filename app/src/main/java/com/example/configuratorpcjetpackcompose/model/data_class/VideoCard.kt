package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class VideoCard(
    @JvmField @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("graphics_processor")
    var _graphicsProcessor: String = "",
    @JvmField @PropertyName("video_memory_capacity")
    var _videoMemoryCapacity: Int = 0,
    @JvmField @PropertyName("gpu_manufacturer")
    var _gpuManufacturer: String = "",
    @JvmField @PropertyName("type_memory")
    var _typeOfMemory: String = "",
    @JvmField @PropertyName("memory_bus_bit_rate")
    var _memoryBusBitRate: Int = 0,
    @JvmField @PropertyName("connection_interface")
    var _connectionInterface: String = "",
    @JvmField @PropertyName("type_number_installed_fans")
    var _typeAndNumberOfInstalledFans: String = "",
    @JvmField @PropertyName("lhr")
    var _lhr: Boolean = false,
    @JvmField @PropertyName("monitors_connected_same_time_count")
    var _monitorsConnectedAtTheSameTimeCount: Int = 0,
    @JvmField @PropertyName("length")
    var _length: Int = 0,
    @JvmField @PropertyName("energy_consumption_max")
    var _energyConsumptionMax: Int = 0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.VIDEO_CARD,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        videoCard: VideoCard
    ) : this(
        _manufacturer = videoCard._manufacturer,
        _graphicsProcessor = videoCard._graphicsProcessor,
        _videoMemoryCapacity = videoCard._videoMemoryCapacity,
        _gpuManufacturer = videoCard._gpuManufacturer,
        _typeOfMemory = videoCard._typeOfMemory,
        _memoryBusBitRate = videoCard._memoryBusBitRate,
        _connectionInterface = videoCard._connectionInterface,
        _typeAndNumberOfInstalledFans = videoCard._typeAndNumberOfInstalledFans,
        _lhr = videoCard._lhr,
        _monitorsConnectedAtTheSameTimeCount = videoCard._monitorsConnectedAtTheSameTimeCount,
        _length = videoCard._length,
        _energyConsumptionMax = videoCard._energyConsumptionMax
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

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
