package com.example.configuratorpcjetpackcompose.components

import com.example.configuratorpcjetpackcompose.R

sealed class ConfigurationElement(var contentDescription: String, var icon: Int, var color: Int) {
    object Processor : ConfigurationElement("Процессор", R.drawable.ic_processor ,R.color.pCYellowElementColor)
    object Motherboard : ConfigurationElement("Материнская плата", R.drawable.ic_motherboard, R.color.pCGreenElementColor)
    object Ram : ConfigurationElement("Оперативная память", R.drawable.ic_ram, R.color.pCPinkElementColor)
    object PowerSupplyUnit : ConfigurationElement("Блок питания", R.drawable.ic_power_supply_unit, R.color.pCBlueElementColor)
    object SoundCard : ConfigurationElement("Звуковая карта", R.drawable.ic_sound_card, R.color.pCYellowElementColor)
    object VideoCard : ConfigurationElement("Видеокарта", R.drawable.ic_videocard, R.color.pCPinkElementColor)
    object Cooler : ConfigurationElement("Охлаждение процессора", R.drawable.ic_cooler, R.color.pCBlueElementColor)
    object DataStorage : ConfigurationElement("Хранение данных", R.drawable.ic_data_storage, R.color.pCYellowElementColor)
    object Case : ConfigurationElement("Корпус", R.drawable.ic_resource_case, R.color.pCGreenElementColor)
    object Monitor : ConfigurationElement("Монитор", R.drawable.ic_monitor, R.color.pCPinkElementColor)
}