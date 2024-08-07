package com.example.domain.model.main_components.data_storage

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

open class DataStorage(
    var manufacturerDataStorage: String = "",
    var thicknessDataStorage: Double = 0.0,
    var memoryCapacity: Int = 0,

    ) : Accessory(
    category = CategoryAccessoryEnum.DATA_STORAGE,
)