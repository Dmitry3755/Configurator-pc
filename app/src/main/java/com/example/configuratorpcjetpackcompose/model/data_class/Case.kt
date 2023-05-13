package com.example.configuratorpcjetpackcompose.model.data_class

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.google.firebase.firestore.PropertyName

data class Case(
    @PropertyName("manufacturer")
    var _manufacturer: String = "",
    @JvmField @PropertyName("form_factor_compatible_boards")
    var _formFactorOfCompatibleBoards: List<String> = listOf(""),
    @JvmField @PropertyName("type_size")
    var _typeSize: String = "",
    @JvmField @PropertyName("placement_power_supply_unit")
    var _placementOfThePowerSupplyUnit: String = "",
    @JvmField @PropertyName("window_material")
    var _windowMaterial: String = "",
    @JvmField @PropertyName("main_color")
    var _mainColor: String = "",
    @JvmField @PropertyName("fans_included")
    var _fansIncluded: String = "",
    @JvmField @PropertyName("presence_window_side_wall")
    var _thePresenceOfAWindowOnTheSideWall: String = "",
    @JvmField @PropertyName("maximum_height_processor_cooler")
    var _maximumHeightOfTheProcessorCooler: Int = 0,
    @JvmField @PropertyName("type_illumination")
    var _typeOfIllumination: String = "",
    @JvmField @PropertyName("fans_count")
    var _fansCount: Int = 0,
    @JvmField @PropertyName("height")
    var _height: Int = 0,
    @JvmField @PropertyName("length_max_video_card")
    var _lengthMaxOfVideoCard: Int = 0,
    @JvmField @PropertyName("max_length_power_supply")
    var _maxLengthOfThePowerSupply: Int = 0,
) : Accessory(
    _categoryAccessoryEnum = CategoryAccessoryEnum.CASE,
) {

    constructor(
        idAccessory: String,
        nameAccessory: String,
        priceAccessory: Double,
        descriptionAccessory: String,
        uriAccessory: String,
        case: Case
    ) : this(
        _manufacturer = case._manufacturer,
        _formFactorOfCompatibleBoards = case._formFactorOfCompatibleBoards,
        _typeSize = case._typeSize,
        _placementOfThePowerSupplyUnit = case._placementOfThePowerSupplyUnit,
        _windowMaterial = case._windowMaterial,
        _mainColor = case._mainColor,
        _fansIncluded = case._fansIncluded,
        _fansCount = case._fansCount,
        _thePresenceOfAWindowOnTheSideWall = case._thePresenceOfAWindowOnTheSideWall,
        _maximumHeightOfTheProcessorCooler = case._maximumHeightOfTheProcessorCooler,
        _typeOfIllumination = case._typeOfIllumination,
        _height = case._height,
        _lengthMaxOfVideoCard = case._lengthMaxOfVideoCard,
        _maxLengthOfThePowerSupply = case._maxLengthOfThePowerSupply
    ) {
        _idAccessory = idAccessory
        _nameAccessory = nameAccessory
        _priceAccessory = priceAccessory
        _descriptionAccessory = descriptionAccessory
        _uriAccessory = uriAccessory
    }

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
    var fansCount: Int
        get() = _fansCount
        set(value) {
            _fansCount = value
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