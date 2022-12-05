package com.example.configuratorpcjetpackcompose.model

open class Ram (
     nameRam: String,
     priceRam: Double,
     descriptionRam: String,
     manufacturerRam: String,
     memoryTypeRam: String,
     memoryModuleCapacityRam: Int,
     frequencyRam: Int,
     casLatencyRam: Double,
        ) : Accessory(
    nameAccessory = nameRam,
    priceAccessory = priceRam,
    descriptionAccessory = descriptionRam,
    categoryAccessoryEnum = CategoryAccessoryEnum.RAM
)