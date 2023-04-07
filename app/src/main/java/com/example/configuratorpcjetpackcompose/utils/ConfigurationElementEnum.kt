package com.example.configuratorpcjetpackcompose.utils

import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.*

enum class ConfigurationElementEnum(var contentDescription: String, var icon: Int, var color: Int, val classAccessoriesTypesList: List<Class<out Accessory>>) {
     Processor("Процессор", R.drawable.ic_processor ,R.color.pc_element_yellow, listOf(Cpu::class.java)),
     Motherboard("Материнская плата", R.drawable.ic_motherboard, R.color.pc_element_green, listOf(com.example.configuratorpcjetpackcompose.model.Motherboard::class.java)),
     Ram("Оперативная память", R.drawable.ic_ram, R.color.pc_element_pink, listOf(SoDimmRam::class.java, DimmRam::class.java)),
     PowerSupplyUnit("Блок питания", R.drawable.ic_power_supply_unit, R.color.pc_element_blue, listOf(com.example.configuratorpcjetpackcompose.model.PowerSupplyUnit::class.java)),
     SoundCard("Звуковая карта", R.drawable.ic_sound_card, R.color.pc_element_yellow,listOf(com.example.configuratorpcjetpackcompose.model.SoundCard::class.java)),
     VideoCard("Видеокарта", R.drawable.ic_videocard, R.color.pc_element_pink,listOf(com.example.configuratorpcjetpackcompose.model.VideoCard::class.java)),
     Cooler("Охлаждение системы", R.drawable.ic_cooler, R.color.pc_element_blue,listOf(CoolerForCpu::class.java, CoolerForCase::class.java)),
     DataStorage("Хранение данных", R.drawable.ic_data_storage, R.color.pc_element_yellow,listOf(Ssd::class.java,HardDrive::class.java)),
     Case("Корпус", R.drawable.ic_resource_case, R.color.pc_element_green,listOf(com.example.configuratorpcjetpackcompose.model.Case::class.java)),
     Monitor("Монитор", R.drawable.ic_monitor, R.color.pc_element_pink,listOf(com.example.configuratorpcjetpackcompose.model.Monitor::class.java))
}