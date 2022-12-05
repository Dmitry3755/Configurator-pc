package com.example.configuratorpcjetpackcompose.model

open class DataStorage(
    nameDataStorage: String,
    priceDataStorage: Double,
    descriptionDataStorage: String,
    manufacturerDataStorage: String,
    thicknessDataStorage: Double,
    memoryCapacity: Int
) : Accessory(
    nameAccessory = nameDataStorage,
    priceAccessory = priceDataStorage,
    descriptionAccessory = descriptionDataStorage,
    categoryAccessoryEnum = CategoryAccessoryEnum.DATA_STORAGE
)