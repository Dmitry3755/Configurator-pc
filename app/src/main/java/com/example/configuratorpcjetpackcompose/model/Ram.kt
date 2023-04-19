package com.example.configuratorpcjetpackcompose.model

import android.net.Uri

open class Ram (
     nameRam: String,
     priceRam: Double,
     descriptionRam: String,
     manufacturerRam: String,
     memoryTypeRam: String,
     memoryModuleCapacityRam: Int,
     frequencyRam: Int,
     casLatencyRam: Double,
     uriRam: String
        ) : Accessory(
    nameAccessory = nameRam,
    priceAccessory = priceRam,
    descriptionAccessory = descriptionRam,
    categoryAccessoryEnum = CategoryAccessoryEnum.RAM,
    uriAccessory = uriRam
)