package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

data class Motherboard(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double =0.0,
    @PropertyName("description")
    var _description: String ="",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("socket")
    val _socket: String ="",
    @PropertyName("chipset")
    val _chipset: String ="",
    @PropertyName("memory_slots_count")
    val _memorySlotsCount: Int =0,
    @PropertyName("for_processes")
    val _forProcesses: String ="",
    @PropertyName("type_supported_memory")
    val _typeOfSupportedMemory: String ="",
    @PropertyName("builtIn_wifi_adapter")
    val _builtInWiFiAdapter: String ="",
    @PropertyName("pci_express_version")
    val _pciExpressVersion: Int = 0,
    @PropertyName("m2_connectors_count")
    val _m2ConnectorsCount: Int =0,
    @PropertyName("form_factor")
    val _formFactor: String ="",
    @PropertyName("energy_consumption_max")
    val _energyConsumptionMax : Int =0,
    @PropertyName("memory_frequency_max")
    val _memoryFrequencyMax : Int =0,
    @JvmField @PropertyName("uri")
    val _uri: String = ""
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.MOTHERBOARD,
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