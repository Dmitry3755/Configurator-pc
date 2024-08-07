package com.example.domain.model

open class Accessory(
    var id: String = "",
    var name: String = "",
    var price: Double  = 0.0,
    var description: String ="",
    val category: CategoryAccessoryEnum,
    var uri : String = ""
)