package com.example.configuratorpcjetpackcompose.model

data class Accessory(
    var nameAccessory: String,
    var priceAccessory: Double,
    var descriptionAccessory: String,
    var categoryAccessoryEnum: CategoryAccessoryEnum
)