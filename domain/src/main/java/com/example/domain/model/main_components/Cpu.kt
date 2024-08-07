package com.example.domain.model.main_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class Cpu(
    var manufacturer: String = "",
    var socket: String = "",
    var family: String = "",
    var productiveCoresCount: Int = 0,
    var integratedGraphicsCore: Boolean = false,
    var releaseYear: Int = 0,
    var memoryType: String = "",
    var baseFrequency: Double = 0.0,
    var heatDissipation: Int = 0,
    var technicalProcess: String = "",
    var pinConnector: String = "",
    var maximumSupportedMemoryCapacity: Int = 0,
) : Accessory(
    category = CategoryAccessoryEnum.PROCESSOR
)