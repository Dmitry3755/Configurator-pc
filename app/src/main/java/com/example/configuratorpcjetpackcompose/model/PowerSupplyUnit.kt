package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class PowerSupplyUnit(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("power_capacity")
    val _powerCapacity: Int =0,
    @PropertyName("certificate80_plus")
    val _certificate80Plus: String ="",
    @PropertyName("detachable_cables")
    val _detachableCables: String ="",
    @PropertyName("form_factor")
    val _formFactor: String ="",
    @PropertyName("connectors_for_video_card")
    val _connectorsForVideoCard: String ="",
    @PropertyName("connectors_for_cpu")
    val _connectorsForCpu: String ="",
    @PropertyName("cooling_system")
    val _coolingSystem: String ="",
    @PropertyName("power_factor_corrector")
    val _powerFactorCorrector: String ="",
    @PropertyName("type_illumination")
    val _typeOfIllumination: String ="",
    @PropertyName("pin15_sata_connectors_counts")
    val _pin15SataConnectorsCounts: Int =0,
    @PropertyName("uri")
    val _uri: String = ""
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.POWER_SUPPLY_UNIT,
    uriAccessory = _uri
)
{
    var name: String
        get() = _name
        set(value) {
            _name = value
            nameAccessory = value
        }
    var price: Double
        get() = _price
        set(value) {
            _price = value
            priceAccessory = value
        }
}