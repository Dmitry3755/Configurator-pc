package com.example.configuratorpcjetpackcompose.model

import com.google.firebase.firestore.PropertyName

data class Case(
    @PropertyName("name")
    var _name: String ="",
    @PropertyName("price")
    var _price: Double = 0.0,
    @PropertyName("description")
    var _description: String = "",
    @PropertyName("manufacturer")
    val _manufacturer: String ="",
    @PropertyName("form_factor_compatible_boards")
    val _formFactorOfCompatibleBoards: List<String> = listOf(""),
    @PropertyName("type_size")
    val _typeSize: String ="",
    @PropertyName("placement_power_supply_unit")
    val _placementOfThePowerSupplyUnit: String ="",
    @PropertyName("window_material")
    val _windowMaterial: String = "",
    @PropertyName("main_color")
    val _mainColor: String="",
    @PropertyName("fans_included")
    val _fansIncluded: String="",
    @PropertyName("presence_window_side_wall")
    val _thePresenceOfAWindowOnTheSideWall: String="",
    @PropertyName("maximum_height_processor_cooler")
    val _maximumHeightOfTheProcessorCooler: Int = 0,
    @PropertyName("type_illumination")
    val _typeOfIllumination: String ="",
    @PropertyName("height")
    val _height: Int =0,
    @PropertyName("length_max_video_card")
    val _lengthMaxOfVideoCard : Int=0,
    @PropertyName("max_length_power_supply")
    val _maxLengthOfThePowerSupply : Int =0
) : Accessory(
    nameAccessory = _name,
    priceAccessory = _price,
    descriptionAccessory = _description,
    categoryAccessoryEnum = CategoryAccessoryEnum.CASE
) {
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