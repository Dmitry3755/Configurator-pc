package com.example.configuratorpcjetpackcompose.utils

import android.content.Context
import androidx.annotation.StringRes

object AppResources {

    private var applicationContext: Context? = null

    fun initializeResources(context: Context) { //Инициализация ресурсов
        applicationContext = context
    }

    fun getString(@StringRes id: Int) =
        applicationContext?.getString(id) ?: "" // Получение строки по id

}