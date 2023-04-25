package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Motherboard(
    @PropertyName("manufacturer")
    var _manufacturer: String ="",
    @PropertyName("socket")
    var _socket: String ="",
    @PropertyName("chipset")
    var _chipset: String ="",
    @PropertyName("memory_slots_count")
    var _memorySlotsCount: Int =0,
    @PropertyName("for_processes")
    var _forProcesses: String ="",
    @PropertyName("type_supported_memory")
    var _typeOfSupportedMemory: String ="",
    @PropertyName("builtIn_wifi_adapter")
    var _builtInWiFiAdapter: String ="",
    @PropertyName("pci_express_version")
    var _pciExpressVersion: Int = 0,
    @PropertyName("m2_connectors_count")
    var _m2ConnectorsCount: Int =0,
    @PropertyName("form_factor")
    var _formFactor: String ="",
    @PropertyName("energy_consumption_max")
    var _energyConsumptionMax : Int =0,
    @PropertyName("memory_frequency_max")
    var _memoryFrequencyMax : Int =0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.MOTHERBOARD,
) {
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
}