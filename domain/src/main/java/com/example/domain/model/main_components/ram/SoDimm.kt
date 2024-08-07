package com.example.domain.model.main_components.ram

data class SoDimm(
    var supplyVoltage: Int = 0,
    var radiator: Boolean = false,
) : Ram()