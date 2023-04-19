package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class SoundCard(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("location")
    val _location: String ="",
    @PropertyName("connection_interface")
    val _connectionInterface: String ="",
    @PropertyName("format")
    val _format: Double =0.0,
    @PropertyName("dac_bit_rate")
    val _dacBitRate: Int =0,
    @PropertyName("professional_adapter_ram")
    val _professionalAdapterRam: Boolean = false,
    @PropertyName("support_asio")
    val _supportAsio: Boolean = false,
    @PropertyName("builtIn_headphone_amplifier")
    val _builtInHeadphoneAmplifier: Boolean = false,
    @PropertyName("support_os")
    val _supportOs: String ="",
    @PropertyName("phantom_microphone_power")
    val _phantomMicrophonePower: Boolean =false,
    @PropertyName("maximum_dac_frequency")
    val _maximumDacFrequency: Double =0.0,
    @PropertyName("instrumental_input")
    val _instrumentalInput: Boolean = false,
    @PropertyName("uri")
    val _uri: String = ""
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.SOUND_CARD,
    uriAccessory = _uri
)
{
    var name: String
        get() = _name
        set(value) {
            _name = value
            nameAccessory = value
        }
    var price: Double
        get() = _price
        set(value) {
            _price = value
            priceAccessory = value
        }
}