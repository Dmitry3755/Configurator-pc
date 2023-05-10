package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

open class Cooler(
    @JvmField @PropertyName("manufacturer")
    var _manufacturerCooler: String = "",
    @JvmField @PropertyName("type_illumination")
    var _typeOfIlluminationCooler: String = ""

) : Accessory(
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