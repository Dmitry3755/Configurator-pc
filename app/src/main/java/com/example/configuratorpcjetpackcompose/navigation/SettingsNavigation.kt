package com.example.configuratorpcjetpackcompose.navigation

sealed class SettingsNavigation(val route: String) {
    object SettingsScreen: Navigation("settings_screen")

}