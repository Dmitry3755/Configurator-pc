package com.example.domain.model.main_components

import com.example.domain.model.Accessory
import com.example.domain.model.CategoryAccessoryEnum

data class VideoCard(
    var manufacturer: String = "",
    var graphicsProcessor: String = "",
    var videoMemoryCapacity: Int = 0,
    var gpuManufacturer: String = "",
    var typeOfMemory: String = "",
    var memoryBusBitRate: Int = 0,
    var connectionInterface: String = "",
    var typeAndNumberOfInstalledFans: String = "",
    var lhr: Boolean = false,
    var monitorsConnectedAtTheSameTimeCount: Int = 0,
    var length: Int = 0,
    var energyConsumptionMax: Int = 0,
    var formFactorConnector: String = "",
) : Accessory(
    category = CategoryAccessoryEnum.VIDEO_CARD,
)
