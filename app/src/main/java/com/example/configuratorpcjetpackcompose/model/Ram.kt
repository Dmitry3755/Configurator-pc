package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

open class Ram(
    @JvmField @PropertyName("manufacturer")
    var _manufacturerRam: String ="",
    @JvmField @PropertyName("memory_type")
    var _memoryTypeRam: String ="",
    @JvmField @PropertyName("memory_module_capacity")
    var _memoryModuleCapacityRam: Int =0,
    @JvmField @PropertyName("frequency")
    var _frequencyRam: Int = 0,
    @JvmField @PropertyName("cas_latency")
    var _casLatencyRam: Double = 0.0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.RAM,
) {
    var manufacturer: String
        get() = _manufacturerRam
        set(value) {
            _manufacturerRam = value
        }
    var memoryType: String
        get() = _memoryTypeRam
        set(value) {
            _memoryTypeRam = value
        }
    var memoryModuleCapacity: Int
        get() = _memoryModuleCapacityRam
        set(value) {
            _memoryModuleCapacityRam = value
        }
    var frequency: Int
        get() = _frequencyRam
        set(value) {
            _frequencyRam = value
        }
    var casLatency: Double
        get() = _casLatencyRam
        set(value) {
            _casLatencyRam = value
        }
}