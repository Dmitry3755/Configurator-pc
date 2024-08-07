package com.example.domain.model.main_components.data_storage

data class HardDrive(
    var purpose: String = "",
    var spindleRotationSpeed: Int = 0,
    var recordingTechnology: String = "",
    var cacheMemorySize: Int = 0,
    var optimizationForRaidArrays: Boolean = false,
    var withHeliumFilling: Boolean = false,
    var noiseLevelDuringOperation: Int = 0,
    var numberOfPositioningParkingCycles: Int = 0,
) : DataStorage()