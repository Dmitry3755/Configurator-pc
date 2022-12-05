package com.example.configuratorpcjetpackcompose.model

data class Case(
    val name: String,
    var price: Double,
    var description: String,
    val manufacturer: String,
    val formFactorOfCompatibleBoards: List<String>,
    val typeSize: String,
    val placementOfThePowerSupplyUnit: String,
    val windowMaterial: String,
    val mainColor: String,
    val fansIncluded: String,
    val thePresenceOfAWindowOnTheSideWall: String,
    val maximumHeightOfTheProcessorCooler: Int,
    val typeOfIllumination: String,
    val height: Int,
    val lengthMaxOfVideoCard : Int,
    val maxLengthOfThePowerSupply : Int
) : Accessory(
    nameAccessory = name,
    priceAccessory = price,
    descriptionAccessory = description,
    categoryAccessoryEnum = CategoryAccessoryEnum.CASE
)