package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Ram
import com.google.firebase.firestore.PropertyName

data class Dimm(
    @PropertyName("frequency")
    var _frequency: Int = 0,
    @PropertyName("presence_radiator")
    var _thePresenceOfARadiator: Boolean = false,
    @PropertyName("illumination_board_elements")
    var _illuminationOfBoardElements: String = "",
    @PropertyName("ecc_memory")
    var _eccMemory: Boolean = false,
    @PropertyName("server_memory")
    var _serverMemory: Boolean = false,
) : Ram() {
    var frequency: Int
        get() = _frequency
        set(value) {
            _frequency = value
        }
    var thePresenceOfARadiator: Boolean
        get() = _thePresenceOfARadiator
        set(value) {
            _thePresenceOfARadiator = value
        }
    var illuminationOfBoardElements: String
        get() = _illuminationOfBoardElements
        set(value) {
            _illuminationOfBoardElements = value
        }
    var eccMemory: Boolean
        get() = _eccMemory
        set(value) {
            _eccMemory = value
        }
    var serverMemory: Boolean
        get() = _serverMemory
        set(value) {
            _serverMemory = value
        }
}