package com.example.configuratorpcjetpackcompose.utils

import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.*
import com.example.data.model.entities.CoolerForCase
import com.example.data.model.entities.CoolerForCpu
import com.example.data.model.entities.Cpu
import com.example.data.model.entities.Dimm
import com.example.data.model.entities.HardDrive
import com.example.data.model.entities.SoDimm
import com.example.data.model.entities.Ssd

enum class ConfigurationElementEnum(var contentDescription: String, var icon: Int, var color: Int, val classAccessoriesTypesList: List<Class<out com.example.data.entities.AccessoryApiResponse>>) {
     Processor("Процессор", R.drawable.ic_processor ,R.color.pc_element_yellow, listOf(com.example.data.model.entities.Cpu::class.java)),
     Motherboard("Материнская плата", R.drawable.ic_motherboard, R.color.pc_element_green, listOf(
          com.example.data.model.entities.Motherboard::class.java)),
     Ram("Оперативная память", R.drawable.ic_ram, R.color.pc_element_pink, listOf(com.example.data.model.entities.SoDimm::class.java, com.example.data.model.entities.Dimm::class.java)),
     PowerSupplyUnit("Блок питания", R.drawable.ic_power_supply_unit, R.color.pc_element_blue, listOf(
          com.example.data.model.entities.PowerSupplyUnit::class.java)),
     SoundCard("Звуковая карта", R.drawable.ic_sound_card, R.color.pc_element_yellow,listOf(com.example.data.model.entities.SoundCard::class.java)),
     VideoCard("Видеокарта", R.drawable.ic_videocard, R.color.pc_element_pink,listOf(com.example.data.model.entities.VideoCard::class.java)),
     Cooler("Охлаждение системы", R.drawable.ic_cooler, R.color.pc_element_blue,listOf(com.example.data.model.entities.CoolerForCpu::class.java, com.example.data.model.entities.CoolerForCase::class.java)),
     DataStorage("Хранение данных", R.drawable.ic_data_storage, R.color.pc_element_yellow,listOf(
          com.example.data.model.entities.Ssd::class.java,
          com.example.data.model.entities.HardDrive::class.java)),
     Case("Корпус", R.drawable.ic_resource_case, R.color.pc_element_green,listOf(com.example.data.model.entities.Case::class.java)),
     Monitor("Монитор", R.drawable.ic_monitor, R.color.pc_element_pink,listOf(com.example.data.model.entities.Monitor::class.java))
}