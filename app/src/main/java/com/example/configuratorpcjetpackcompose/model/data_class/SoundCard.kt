package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class SoundCard(
    @JvmField @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("location")
    var _location: String = "",
    @JvmField @PropertyName("connection_interface")
    var _connectionInterface: String = "",
    @JvmField @PropertyName("format")
    var _format: Double = 0.0,
    @JvmField @PropertyName("dac_bit_rate")
    var _dacBitRate: Int = 0,
    @JvmField @PropertyName("professional_adapter_ram")
    var _professionalAdapterRam: Boolean = false,
    @JvmField @PropertyName("support_asio")
    var _supportAsio: Boolean = false,
    @JvmField @PropertyName("builtIn_headphone_amplifier")
    var _builtInHeadphoneAmplifier: Boolean = false,
    @JvmField @PropertyName("support_os")
    var _supportOs: List<String> = listOf(""),
    @JvmField @PropertyName("phantom_microphone_power")
    var _phantomMicrophonePower: Boolean = false,
    @JvmField @PropertyName("maximum_dac_frequency")
    var _maximumDacFrequency: Double = 0.0,
    @JvmField @PropertyName("instrumental_input")
    var _instrumentalInput: Boolean = false,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.SOUND_CARD,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        soundCard: SoundCard
    ) : this(
        _manufacturer = soundCard._manufacturer,
        _location = soundCard._location,
        _connectionInterface = soundCard._connectionInterface,
        _format = soundCard._format,
        _dacBitRate = soundCard._dacBitRate,
        _professionalAdapterRam = soundCard._professionalAdapterRam,
        _supportAsio = soundCard._supportAsio,
        _builtInHeadphoneAmplifier = soundCard._builtInHeadphoneAmplifier,
        _supportOs = soundCard._supportOs,
        _phantomMicrophonePower = soundCard._phantomMicrophonePower,
        _maximumDacFrequency = soundCard._maximumDacFrequency,
        _instrumentalInput = soundCard._instrumentalInput
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
    var supportOs: List<String>
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