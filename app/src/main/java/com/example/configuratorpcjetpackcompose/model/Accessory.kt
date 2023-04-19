package com.example.configuratorpcjetpackcompose.model

import android.net.Uri

open class Accessory(
    var nameAccessory: String,
    var priceAccessory: Double,
    var descriptionAccessory: String,
    val categoryAccessoryEnum: CategoryAccessoryEnum,
    var uriAccessory: String
)