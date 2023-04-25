package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class SoundCard(
    @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @PropertyName("location")
    var _location: String = "",
    @PropertyName("connection_interface")
    var _connectionInterface: String = "",
    @PropertyName("format")
    var _format: Double = 0.0,
    @PropertyName("dac_bit_rate")
    var _dacBitRate: Int = 0,
    @PropertyName("professional_adapter_ram")
    var _professionalAdapterRam: Boolean = false,
    @PropertyName("support_asio")
    var _supportAsio: Boolean = false,
    @PropertyName("builtIn_headphone_amplifier")
    var _builtInHeadphoneAmplifier: Boolean = false,
    @PropertyName("support_os")
    var _supportOs: String = "",
    @PropertyName("phantom_microphone_power")
    var _phantomMicrophonePower: Boolean = false,
    @PropertyName("maximum_dac_frequency")
    var _maximumDacFrequency: Double = 0.0,
    @PropertyName("instrumental_input")
    var _instrumentalInput: Boolean = false,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.SOUND_CARD,
) {
    var manufacturer: String
        get() = _manufacturer
        set(value) {
            _manufacturer = value
        }
    var location: String
        get() = _location
        set(value) {
            _location = value
        }
    var connectionInterface: String
        get() = _connectionInterface
        set(value) {
            _connectionInterface = value
        }
    var format: Double
        get() = _format
        set(value) {
            _format = value
        }
    var dacBitRate: Int
        get() = _dacBitRate
        set(value) {
            _dacBitRate = value
        }
    var professionalAdapterRam: Boolean
        get() = _professionalAdapterRam
        set(value) {
            _professionalAdapterRam = value
        }
    var supportAsio: Boolean
        get() = _supportAsio
        set(value) {
            _supportAsio = value
        }
    var builtInHeadphoneAmplifier: Boolean
        get() = _builtInHeadphoneAmplifier
        set(value) {
            _builtInHeadphoneAmplifier = value
        }
    var supportOs: String
        get() = _supportOs
        set(value) {
            _supportOs = value
        }
    var phantomMicrophonePower: Boolean
        get() = _phantomMicrophonePower
        set(value) {
            _phantomMicrophonePower = value
        }
    var maximumDacFrequency: Double
        get() = _maximumDacFrequency
        set(value) {
            _maximumDacFrequency = value
        }
    var instrumentalInput: Boolean
        get() = _instrumentalInput
        set(value) {
            _instrumentalInput = value
        }
}