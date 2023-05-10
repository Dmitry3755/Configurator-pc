package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Ram
import com.google.firebase.firestore.PropertyName

data class Dimm(
    @JvmField @PropertyName("presence_radiator")
    var _thePresenceOfARadiator: Boolean = false,
    @JvmField @PropertyName("illumination_board_elements")
    var _illuminationOfBoardElements: String = "",
    @JvmField @PropertyName("ecc_memory")
    var _eccMemory: Boolean = false,
    @JvmField @PropertyName("server_memory")
    var _serverMemory: Boolean = false,
) : Ram() {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        dimm: Dimm
    ) : this(
        _thePresenceOfARadiator = dimm._thePresenceOfARadiator,
        _illuminationOfBoardElements = dimm._illuminationOfBoardElements,
        _eccMemory = dimm._eccMemory,
        _serverMemory = dimm._serverMemory
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
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