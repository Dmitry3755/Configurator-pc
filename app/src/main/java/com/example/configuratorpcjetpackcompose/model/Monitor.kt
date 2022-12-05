package com.example.configuratorpcjetpackcompose.model

data class Monitor(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val frequencyAtMaximumResolution: Int,
    val maximumResolution: String,
    val screenDiagonal: Int,
    val matrixManufacturingTechnology: String,
    val curvedScreen: Boolean,
    val aspectRatio: String,
    val hdmi: Boolean,
    val hdrSupport: String,
    val dynamicScreenRefreshTechnology: String,
    val displayPortConnector: Boolean
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.DISPLAY
)