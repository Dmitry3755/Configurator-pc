package com.example.configuratorpcjetpackcompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.navigation.BottomNavigationItem
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

sealed class ConfigurationElement(var contentDescription: String, var icon: Int, var color: Int) {
    object Processor : ConfigurationElement("Processor", R.drawable.ic_processor ,R.color.pCYellowElementColor)
    object MatherBoard : ConfigurationElement("Mather board", R.drawable.ic_mather_board, R.color.pCGreenElementColor)
    object RAM : ConfigurationElement("RAM", R.drawable.ic_ram, R.color.pCPinkElementColor)
    object PowerSupplyUnit : ConfigurationElement("Power supply unit", R.drawable.ic_power_supply_unit, R.color.pCBlueElementColor)
    object SoundCard : ConfigurationElement("Sound card", R.drawable.ic_sound_card, R.color.pCYellowElementColor)
    object VideoCard : ConfigurationElement("Video card", R.drawable.ic_videocard, R.color.pCPinkElementColor)
    object Cooler : ConfigurationElement("Cooler", R.drawable.ic_cooler, R.color.pCBlueElementColor)
    object DataStorage : ConfigurationElement("Data storage", R.drawable.ic_data_storage, R.color.pCYellowElementColor)
    object Case : ConfigurationElement("Case", R.drawable.ic_resource_case, R.color.pCGreenElementColor)
    object Monitor : ConfigurationElement("Monitor", R.drawable.ic_monitor, R.color.pCPinkElementColor)
}