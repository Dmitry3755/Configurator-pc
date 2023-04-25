package com.example.configuratorpcjetpackcompose.model.dataclass

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Case(
    @PropertyName("manufacturer")
    var _manufacturer: String ="",
    @PropertyName("form_factor_compatible_boards")
    var _formFactorOfCompatibleBoards: List<String> = listOf(""),
    @PropertyName("type_size")
    var _typeSize: String ="",
    @PropertyName("placement_power_supply_unit")
    var _placementOfThePowerSupplyUnit: String ="",
    @PropertyName("window_material")
    var _windowMaterial: String = "",
    @PropertyName("main_color")
    var _mainColor: String="",
    @PropertyName("fans_included")
    var _fansIncluded: String="",
    @PropertyName("presence_window_side_wall")
    var _thePresenceOfAWindowOnTheSideWall: String="",
    @PropertyName("maximum_height_processor_cooler")
    var _maximumHeightOfTheProcessorCooler: Int = 0,
    @PropertyName("type_illumination")
    var _typeOfIllumination: String ="",
    @PropertyName("height")
    var _height: Int =0,
    @PropertyName("length_max_video_card")
    var _lengthMaxOfVideoCard : Int=0,
    @PropertyName("max_length_power_supply")
    var _maxLengthOfThePowerSupply : Int =0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.CASE,
) {
    var manufacturer: String
        get() = _manufacturer
        set(value) {
            _manufacturer = value
        }
    var formFactorOfCompatibleBoards: List<String>
        get() = _formFactorOfCompatibleBoards
        set(value) {
            _formFactorOfCompatibleBoards = value
        }
    var typeSize: String
        get() = _typeSize
        set(value) {
            _typeSize = value
        }
    var placementOfThePowerSupplyUnit: String
        get() = _placementOfThePowerSupplyUnit
        set(value) {
            _placementOfThePowerSupplyUnit = value
        }
    var windowMaterial: String
        get() = _windowMaterial
        set(value) {
            _windowMaterial = value
        }
    var mainColor: String
        get() = _mainColor
        set(value) {
            _mainColor = value
        }
    var fansIncluded: String
        get() = _fansIncluded
        set(value) {
            _fansIncluded = value
        }
    var thePresenceOfAWindowOnTheSideWall: String
        get() = _thePresenceOfAWindowOnTheSideWall
        set(value) {
            _thePresenceOfAWindowOnTheSideWall = value
        }
    var maximumHeightOfTheProcessorCooler: Int
        get() = _maximumHeightOfTheProcessorCooler
        set(value) {
            _maximumHeightOfTheProcessorCooler = value
        }
    var typeOfIllumination: String
        get() = _typeOfIllumination
        set(value) {
            _typeOfIllumination = value
        }
    var height: Int
        get() = _height
        set(value) {
            _height = value
        }
    var lengthMaxOfVideoCard: Int
        get() = _lengthMaxOfVideoCard
        set(value) {
            _lengthMaxOfVideoCard = value
        }
    var maxLengthOfThePowerSupply: Int
        get() = _maxLengthOfThePowerSupply
        set(value) {
            _maxLengthOfThePowerSupply = value
        }
}