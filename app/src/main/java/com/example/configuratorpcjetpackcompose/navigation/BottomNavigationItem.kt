package com.example.configuratorpcjetpackcompose.navigation

import com.example.configuratorpcjetpackcompose.R

sealed class BottomNavigationItem(var route: String, var icon: Int, var title: String) {
    object ConfigurationScreen : BottomNavigationItem("configuration_ screen", R.drawable.ic_pc_computer, "Конфигуратор")
    object FavoriteScreen : BottomNavigationItem("favorite_screen", R.drawable.ic_favorite, "Избранное")
    object SearchScreen :BottomNavigationItem("search_screen", R.drawable.ic_search, "Поиск")
    object SettingsScreen : BottomNavigationItem("settings_screen", R.drawable.ic_settings, "Настройки")
    object AccountScreen : BottomNavigationItem("account_screen", R.drawable.ic_account, "Аккаунт")
}