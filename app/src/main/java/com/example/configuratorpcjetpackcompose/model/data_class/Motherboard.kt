package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Motherboard(
    @JvmField @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("socket")
    var _socket: String = "",
    @JvmField @PropertyName("chipset")
    var _chipset: String = "",
    @JvmField @PropertyName("memory_slots_count")
    var _memorySlotsCount: Int = 0,
    @JvmField @PropertyName("for_processes")
    var _forProcesses: String = "",
    @JvmField @PropertyName("type_supported_memory")
    var _typeOfSupportedMemory: String = "",
    @JvmField @PropertyName("builtIn_wifi_adapter")
    var _builtInWiFiAdapter: String = "",
    @JvmField @PropertyName("pci_express_version")
    var _pciExpressVersion: Int = 0,
    @JvmField @PropertyName("m2_connectors_count")
    var _m2ConnectorsCount: Int = 0,
    @JvmField @PropertyName("form_factor")
    var _formFactor: String = "",
    @JvmField @PropertyName("energy_consumption_max")
    var _energyConsumptionMax: Int = 0,
    @JvmField @PropertyName("memory_frequency_max")
    var _memoryFrequencyMax: Int = 0,
    @JvmField @PropertyName("all_slots")
    var _allSlots: List<String> = listOf(),
    @JvmField @PropertyName("supported_memory_form_factor")
    var _supportedMemoryFormFactor: String = ""
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.MOTHERBOARD,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        motherboard: Motherboard
    ) : this(
        _manufacturer = motherboard._manufacturer,
        _socket = motherboard._socket,
        _chipset = motherboard._chipset,
        _memorySlotsCount = motherboard._memorySlotsCount,
        _forProcesses = motherboard._forProcesses,
        _typeOfSupportedMemory = motherboard._typeOfSupportedMemory,
        _builtInWiFiAdapter = motherboard._builtInWiFiAdapter,
        _pciExpressVersion = motherboard._pciExpressVersion,
        _m2ConnectorsCount = motherboard._m2ConnectorsCount,
        _formFactor = motherboard._formFactor,
        _energyConsumptionMax = motherboard._energyConsumptionMax,
        _memoryFrequencyMax = motherboard._memoryFrequencyMax
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
    var supportedMemoryFormFactor: String
        get() = _supportedMemoryFormFactor
        set(value) {
            _supportedMemoryFormFactor = value
        }
    var socket: String
        get() = _socket
        set(value) {
            _socket = value
        }
    var chipset: String
        get() = _chipset
        set(value) {
            _chipset = value
        }
    var memorySlotsCount: Int
        get() = _memorySlotsCount
        set(value) {
            _memorySlotsCount = value
        }
    var forProcesses: String
        get() = _forProcesses
        set(value) {
            _forProcesses = value
        }
    var typeOfSupportedMemory: String
        get() = _typeOfSupportedMemory
        set(value) {
            _typeOfSupportedMemory = value
        }
    var builtInWiFiAdapter: String
        get() = _builtInWiFiAdapter
        set(value) {
            _builtInWiFiAdapter = value
        }
    var pciExpressVersion: Int
        get() = _pciExpressVersion
        set(value) {
            _pciExpressVersion = value
        }
    var m2ConnectorsCount: Int
        get() = _m2ConnectorsCount
        set(value) {
            _m2ConnectorsCount = value
        }
    var formFactor: String
        get() = _formFactor
        set(value) {
            _formFactor = value
        }
    var energyConsumptionMax: Int
        get() = _energyConsumptionMax
        set(value) {
            _energyConsumptionMax = value
        }
    var memoryFrequencyMax: Int
        get() = _memoryFrequencyMax
        set(value) {
            _memoryFrequencyMax = value
        }
    var slotsForVideoCardsList: List<String>
        get() = _allSlots
        set(value) {
            _allSlots = value
        }
}