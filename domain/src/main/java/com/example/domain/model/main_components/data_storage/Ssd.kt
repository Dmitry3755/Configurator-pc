package com.example.domain.model.main_components.data_storage

data class Ssd(
    var type: String = "",
    var connectionConnector: String = "",
    var maximumRecordingResource: Double = 0.0,
    var maximumSequentialReadSpeed: Int = 0,
    var dramBuffer: Boolean = false,
    var maximumSequentialWriteSpeed: Int = 0,
    var numberOfBitsPerCell: String = "",
    var memoryStructure: String = "",
    var dwpd: Double = 0.0,
) : DataStorage()