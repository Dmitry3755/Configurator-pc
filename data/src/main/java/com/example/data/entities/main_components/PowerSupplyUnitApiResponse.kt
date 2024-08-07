package com.example.data.entities.main_components

import com.example.data.entities.AccessoryApiResponse
import com.example.domain.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class PowerSupplyUnitApiResponse(
    @JvmField @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("power_capacity")
    var _powerCapacity: Int = 0,
    @JvmField @PropertyName("certificate80_plus")
    var _certificate80Plus: String = "",
    @JvmField @PropertyName("detachable_cables")
    var _detachableCables: String = "",
    @JvmField @PropertyName("form_factor")
    var _formFactor: String = "",
    @JvmField @PropertyName("connectors_for_video_card")
    var _connectorsForVideoCard: String = "",
    @JvmField @PropertyName("connectors_for_cpu")
    var _connectorsForCpu: String = "",
    @JvmField @PropertyName("cooling_system")
    var _coolingSystem: String = "",
    @JvmField @PropertyName("power_factor_corrector")
    var _powerFactorCorrector: String = "",
    @JvmField @PropertyName("type_illumination")
    var _typeOfIllumination: String = "",
    @JvmField @PropertyName("pin15_sata_connectors_counts")
    var _pin15SataConnectorsCounts: Int = 0,
) : AccessoryApiResponse(
    _categoryAccessoryEnum = CategoryAccessoryEnum.POWER_SUPPLY_UNIT,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        powerSupplyUnit: PowerSupplyUnitApiResponse
    ) : this(
        _manufacturer = powerSupplyUnit._manufacturer,
        _powerCapacity = powerSupplyUnit._powerCapacity,
        _certificate80Plus = powerSupplyUnit._certificate80Plus,
        _detachableCables = powerSupplyUnit._detachableCables,
        _formFactor = powerSupplyUnit._formFactor,
        _connectorsForVideoCard = powerSupplyUnit._connectorsForVideoCard,
        _connectorsForCpu = powerSupplyUnit._connectorsForCpu,
        _coolingSystem = powerSupplyUnit._coolingSystem,
        _powerFactorCorrector = powerSupplyUnit._powerFactorCorrector,
        _typeOfIllumination = powerSupplyUnit._typeOfIllumination,
        _pin15SataConnectorsCounts = powerSupplyUnit._pin15SataConnectorsCounts
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

    var manufacturer: String
        get() = _manufacturer
        set(value) {
            _manufacturer = value
        }
    var powerCapacity: Int
        get() = _powerCapacity
        set(value) {
            _powerCapacity = value
        }
    var certificate80Plus: String
        get() = _certificate80Plus
        set(value) {
            _certificate80Plus = value
        }
    var detachableCables: String
        get() = _detachableCables
        set(value) {
            _detachableCables = value
        }
    var formFactor: String
        get() = _formFactor
        set(value) {
            _formFactor = value
        }
    var connectorsForVideoCard: String
        get() = _connectorsForVideoCard
        set(value) {
            _connectorsForVideoCard = value
        }
    var connectorsForCpu: String
        get() = _connectorsForCpu
        set(value) {
            _connectorsForCpu = value
        }
    var coolingSystem: String
        get() = _coolingSystem
        set(value) {
            _coolingSystem = value
        }
    var powerFactorCorrector: String
        get() = _powerFactorCorrector
        set(value) {
            _powerFactorCorrector = value
        }
    var typeOfIllumination: String
        get() = _typeOfIllumination
        set(value) {
            _typeOfIllumination = value
        }
    var pin15SataConnectorsCounts: Int
        get() = _pin15SataConnectorsCounts
        set(value) {
            _pin15SataConnectorsCounts = value
        }
}