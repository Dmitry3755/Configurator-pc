package com.example.configuratorpcjetpackcompose.model

data class SoundCard(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val location: String,
    val connectionInterface: String,
    val format: Double,
    val dacBitRate: Int,
    val professionalAdapterRam: Boolean,
    val supportAsio: Boolean,
    val builtInHeadphoneAmplifier: Boolean,
    val supportOs: String,
    val phantomMicrophonePower: Boolean,
    val maximumDacFrequency: Double,
    val instrumentalInput: Boolean
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.SOUND_CARD
)