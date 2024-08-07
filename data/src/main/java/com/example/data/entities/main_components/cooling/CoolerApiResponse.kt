package com.example.data.entities.main_components.cooling

import com.example.data.entities.AccessoryApiResponse
import com.example.domain.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

open class CoolerApiResponse(
    @JvmField @PropertyName("manufacturer")
    var _manufacturerCooler: String = "",
    @JvmField @PropertyName("type_illumination")
    var _typeOfIlluminationCooler: String = ""

) : AccessoryApiResponse(
    _categoryAccessoryEnum = CategoryAccessoryEnum.COOLER,
) {
    var manufacturer: String
        get() = _manufacturerCooler
        set(value) {
            _manufacturerCooler = value
        }
    var typeIllumination: String
        get() = _typeOfIlluminationCooler
        set(value) {
            _typeOfIlluminationCooler = value
        }
}