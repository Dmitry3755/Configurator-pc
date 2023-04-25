package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class PowerSupplyUnit(
    @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @PropertyName("power_capacity")
    var _powerCapacity: Int = 0,
    @PropertyName("certificate80_plus")
    var _certificate80Plus: String = "",
    @PropertyName("detachable_cables")
    var _detachableCables: String = "",
    @PropertyName("form_factor")
    var _formFactor: String = "",
    @PropertyName("connectors_for_video_card")
    var _connectorsForVideoCard: String = "",
    @PropertyName("connectors_for_cpu")
    var _connectorsForCpu: String = "",
    @PropertyName("cooling_system")
    var _coolingSystem: String = "",
    @PropertyName("power_factor_corrector")
    var _powerFactorCorrector: String = "",
    @PropertyName("type_illumination")
    var _typeOfIllumination: String = "",
    @PropertyName("pin15_sata_connectors_counts")
    var _pin15SataConnectorsCounts: Int = 0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.POWER_SUPPLY_UNIT,
) {
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