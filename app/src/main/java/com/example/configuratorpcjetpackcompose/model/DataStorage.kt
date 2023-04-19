package com.example.configuratorpcjetpackcompose.model

import android.net.Uri

open class DataStorage(
    nameDataStorage: String,
    priceDataStorage: Double,
    descriptionDataStorage: String,
    manufacturerDataStorage: String,
    thicknessDataStorage: Double,
    memoryCapacity: Int,
    uriMemory: String
) : Accessory(
    nameAccessory = nameDataStorage,
    priceAccessory = priceDataStorage,
    descriptionAccessory = descriptionDataStorage,
    categoryAccessoryEnum = CategoryAccessoryEnum.DATA_STORAGE,
    uriAccessory = uriMemory
)