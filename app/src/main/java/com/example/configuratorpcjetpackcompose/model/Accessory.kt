package com.example.configuratorpcjetpackcompose.model

import java.util.TreeSet

open class Accessory(
    var nameAccessory: String,
    var priceAccessory: Double,
    var descriptionAccessory: String,
    val categoryAccessoryEnum: CategoryAccessoryEnum
)