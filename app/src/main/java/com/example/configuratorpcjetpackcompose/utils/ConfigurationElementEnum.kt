package com.example.configuratorpcjetpackcompose.utils

import com.example.configuratorpcjetpackcompose.R

enum class ConfigurationElementEnum(var contentDescription: String, var icon: Int, var color: Int) {
     Processor("Процессор", R.drawable.ic_processor ,R.color.pc_element_yellow),
     Motherboard("Материнская плата", R.drawable.ic_motherboard, R.color.pc_element_green),
     Ram("Оперативная память", R.drawable.ic_ram, R.color.pc_element_pink),
     PowerSupplyUnit("Блок питания", R.drawable.ic_power_supply_unit, R.color.pc_element_blue),
     SoundCard("Звуковая карта", R.drawable.ic_sound_card, R.color.pc_element_yellow),
     VideoCard("Видеокарта", R.drawable.ic_videocard, R.color.pc_element_pink),
     Cooler("Охлаждение процессора", R.drawable.ic_cooler, R.color.pc_element_blue),
     DataStorage("Хранение данных", R.drawable.ic_data_storage, R.color.pc_element_yellow),
     Case("Корпус", R.drawable.ic_resource_case, R.color.pc_element_green),
     Monitor("Монитор", R.drawable.ic_monitor, R.color.pc_element_pink)
}