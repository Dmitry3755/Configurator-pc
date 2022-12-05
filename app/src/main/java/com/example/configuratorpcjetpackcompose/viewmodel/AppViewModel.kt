package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.model.Accessory
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(application: Application) : AndroidViewModel(application) {

    var selectedTheme =  mutableStateOf(ThemeTypeEnum.System)
    var darkTheme = mutableStateOf(false)
    var configurationPc: MutableList<MutableList<Accessory>> = mutableListOf()

    init {
        for (elementType in ConfigurationElementEnum.values()) {
            configurationPc.add(mutableListOf())
        }
    }

    private val _theme = MutableLiveData(false)
    val theme: LiveData<Boolean> = _theme

    fun onThemeChanged(newTheme: Boolean) {
        _theme.value = newTheme
    }
}