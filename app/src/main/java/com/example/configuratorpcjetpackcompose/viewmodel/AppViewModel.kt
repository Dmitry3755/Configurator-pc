package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.components.ConfigurationElement
import com.example.configuratorpcjetpackcompose.components.LargeConfigurationElementLine
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

class AppViewModel(application: Application) : AndroidViewModel(application) {

    var selectedTheme =  mutableStateOf(ThemeTypeEnum.System)

    var configurationPc: MutableList<MutableList<Accessory>> = mutableListOf()

    init {
        for (elementType in ConfigurationElement::class.nestedClasses.map { it.objectInstance as ConfigurationElement }) { //TODO: Убрать костыль
            configurationPc.add(mutableListOf())
        }
    }

}