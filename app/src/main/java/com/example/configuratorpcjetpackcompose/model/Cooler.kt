package com.example.configuratorpcjetpackcompose.model

open class Cooler(
    nameCooler: String,
    priceCooler: Double,
    descriptionCooler: String,
    manufacturerCooler: String,
    typeOfIlluminationCooler: String

) : Accessory(
    nameAccessory = nameCooler,
    priceAccessory = priceCooler,
    descriptionAccessory = descriptionCooler,
    categoryAccessoryEnum = CategoryAccessoryEnum.COOLER
)