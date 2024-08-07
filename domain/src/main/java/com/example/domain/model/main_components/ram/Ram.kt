package com.example.domain.model.main_components.ram

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

open class Ram(
    var manufacturerRam: String ="",
    var memoryTypeRam: String ="",
    var memoryModuleCapacityRam: Int =0,
    var frequencyRam: Int = 0,
    var casLatencyRam: Double = 0.0,
) : Accessory(
    category = CategoryAccessoryEnum.RAM,
)