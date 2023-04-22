package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.configuratorpcjetpackcompose.utils.ThemeTypeEnum
import android.content.res.Configuration

class AppViewModel(application: Application) : AndroidViewModel(application) {

    var selectedTheme =  mutableStateOf(ThemeTypeEnum.System)
    var darkTheme = mutableStateOf(false)

    private val _theme = MutableLiveData(false)
    val theme: MutableLiveData<Boolean> = _theme

    fun onThemeChanged(newTheme: Boolean) {
        _theme.value = newTheme
    }
}