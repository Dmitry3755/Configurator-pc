package com.example.data.entities.main_components

import com.example.data.entities.AccessoryApiResponse
import com.example.domain.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class CpuApiResponse(
    @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @PropertyName("socket")
    var _socket: String = "",
    @PropertyName("family")
    var _family: String = "",
    @JvmField @PropertyName("productive_cores_count")
    var _productiveCoresCount: Int = 0,
    @JvmField @PropertyName("integrated_graphics_core")
    var _integratedGraphicsCore: Boolean = false,
    @JvmField @PropertyName("release_year")
    var _releaseYear: Int = 0,
    @JvmField @PropertyName("memory_type")
    var _memoryType: String = "",
    @JvmField @PropertyName("base_frequency")
    var _baseFrequency: Double = 0.0,
    @JvmField @PropertyName("heat_dissipation")
    var _heatDissipation: Int = 0,
    @JvmField @PropertyName("technical_process")
    var _technicalProcess: String = "",
    @JvmField @PropertyName("pin_connector")
    var _pinConnector: String = "",
    @JvmField @PropertyName("maximum_supported_memory_capacity")
    var _maximumSupportedMemoryCapacity: Int = 0,
) : AccessoryApiResponse(
    _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR
) {
    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        cpu: CpuApiResponse
    ) : this(
        _manufacturer = cpu._manufacturer,
        _socket = cpu._socket,
        _family = cpu._family,
        _productiveCoresCount = cpu._productiveCoresCount,
        _integratedGraphicsCore = cpu._integratedGraphicsCore,
        _releaseYear = cpu._releaseYear,
        _memoryType = cpu._memoryType,
        _baseFrequency = cpu._baseFrequency,
        _heatDissipation = cpu._heatDissipation,
        _technicalProcess = cpu._technicalProcess,
        _pinConnector = cpu._pinConnector,
        _maximumSupportedMemoryCapacity = cpu._maximumSupportedMemoryCapacity
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
    var socket: String
        get() = _socket
        set(value) {
            _socket = value
        }
    var family: String
        get() = _family
        set(value) {
            _family = value
        }
    var productiveCoresCount: Int
        get() = _productiveCoresCount
        set(value) {
            _productiveCoresCount = value
        }
    var integratedGraphicsCore: Boolean
        get() = _integratedGraphicsCore
        set(value) {
            _integratedGraphicsCore = value
        }
    var releaseYear: Int
        get() = _releaseYear
        set(value) {
            _releaseYear = value
        }
    var memoryType: String
        get() = _memoryType
        set(value) {
            _memoryType = value
        }
    var baseFrequency: Double
        get() = _baseFrequency
        set(value) {
            _baseFrequency = value
        }
    var heatDissipation: Int
        get() = _heatDissipation
        set(value) {
            _heatDissipation = value
        }
    var technicalProcess: String
        get() = _technicalProcess
        set(value) {
            _technicalProcess = value
        }
    var pinConnector: String
        get() = _pinConnector
        set(value) {
            _pinConnector = value
        }
    var maximumSupportedMemoryCapacity: Int
        get() = _maximumSupportedMemoryCapacity
        set(value) {
            _maximumSupportedMemoryCapacity = value
        }
}
