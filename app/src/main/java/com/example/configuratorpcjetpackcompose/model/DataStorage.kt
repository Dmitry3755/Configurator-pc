package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

open class DataStorage(
    @PropertyName("manufacturer")
    var _manufacturerDataStorage: String = "",
    @PropertyName("thickness")
    var _thicknessDataStorage: Double = 0.0,
    @PropertyName("memory_capacity")
    var _memoryCapacity: Int = 0,

    ) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.DATA_STORAGE,
) {
    var manufacturerDataStorage: String
        get() = _manufacturerDataStorage
        set(value) {
            _manufacturerDataStorage = value
        }
    var thicknessDataStorage: Double
        get() = _thicknessDataStorage
        set(value) {
            _thicknessDataStorage = value
        }
    var memoryCapacity: Int
        get() = _memoryCapacity
        set(value) {
            _memoryCapacity = value
        }
}
