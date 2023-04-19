package com.example.configuratorpcjetpackcompose.model

import android.net.Uri

open class Cooler(
    nameCooler: String,
    priceCooler: Double,
    descriptionCooler: String,
    manufacturerCooler: String,
    typeOfIlluminationCooler: String,
    uriCooler: String

) : Accessory(
    nameAccessory = nameCooler,
    priceAccessory = priceCooler,
    descriptionAccessory = descriptionCooler,
    categoryAccessoryEnum = CategoryAccessoryEnum.COOLER,
    uriAccessory = uriCooler
)