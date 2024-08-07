package com.example.domain.model.secondary_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class Monitor(
    var manufacturer: String = "",
    var frequencyAtMaximumResolution: Int = 0,
    var maximumResolution: String = "",
    var screenDiagonal: Int = 0,
    var matrixManufacturingTechnology: String = "",
    var curvedScreen: Boolean = false,
    var aspectRatio: String = "",
    var hdmi: Boolean = false,
    var hdrSupport: String = "",
    var dynamicScreenRefreshTechnology: String = "",
    var displayPortConnector: Boolean = false,
) : Accessory(
    category = CategoryAccessoryEnum.DISPLAY,
)