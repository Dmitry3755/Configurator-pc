package com.example.configuratorpcjetpackcompose.model

import android.net.Uri
import com.google.firebase.firestore.PropertyName

open class Ram(
    @PropertyName("manufacturer")
    var _manufacturerRam: String ="",
    @PropertyName("memory_type")
    var _memoryTypeRam: String ="",
    @PropertyName("memory_module_capacity")
    var _memoryModuleCapacityRam: Int =0,
    @PropertyName("frequency")
    var _frequencyRam: Int = 0,
    @PropertyName("cas_latency")
    var _casLatencyRam: Double = 0.0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.RAM,
)