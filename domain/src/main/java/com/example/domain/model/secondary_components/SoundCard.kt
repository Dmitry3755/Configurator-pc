package com.example.domain.model.secondary_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class SoundCard(
    var manufacturer: String = "",
    var location: String = "",
    var connectionInterface: String = "",
    var format: Double = 0.0,
    var dacBitRate: Int = 0,
    var professionalAdapterRam: Boolean = false,
    var supportAsio: Boolean = false,
    var builtInHeadphoneAmplifier: Boolean = false,
    var supportOs: List<String> = listOf(""),
    var phantomMicrophonePower: Boolean = false,
    var maximumDacFrequency: Double = 0.0,
    var instrumentalInput: Boolean = false,
) : Accessory(
    category= CategoryAccessoryEnum.SOUND_CARD,
)