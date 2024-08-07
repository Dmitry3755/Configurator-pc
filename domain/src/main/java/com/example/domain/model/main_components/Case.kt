package com.example.domain.model.main_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class Case(
    var manufacturer: String = "",
    var formFactorOfCompatibleBoards: List<String> = listOf(""),
    var typeSize: String = "",
    var placementOfThePowerSupplyUnit: String = "",
    var windowMaterial: String = "",
    var mainColor: String = "",
    var fansIncluded: String = "",
    var thePresenceOfAWindowOnTheSideWall: String = "",
    var maximumHeightOfTheProcessorCooler: Int = 0,
    var typeOfIllumination: String = "",
    var fansCount: Int = 0,
    var height: Int = 0,
    var lengthMaxOfVideoCard: Int = 0,
    var maxLengthOfThePowerSupply: Int = 0,
) : Accessory(
    category = CategoryAccessoryEnum.CASE,
)