package com.example.domain.model.main_components.cooling.air_cooling

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

open class Cooler(
    var manufacturerCooler: String = "",
    var typeOfIlluminationCooler: String = ""

) : Accessory(
    category = CategoryAccessoryEnum.COOLER,
)