package com.example.domain.model.main_components.ram

data class Dimm(
    var thePresenceOfARadiator: Boolean = false,
    var illuminationOfBoardElements: String = "",
    var eccMemory: Boolean = false,
    var serverMemory: Boolean = false,
) : Ram()