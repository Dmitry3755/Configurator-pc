package com.example.configuratorpcjetpackcompose.navigation

sealed class SettingsNavigation(val route: String) {
    object SettingsScreen : SettingsNavigation("settings_screen")
    object SettingsThemeScreen : SettingsNavigation("settings_theme_screen")
    object SettingsChangePasswordScreen : SettingsNavigation("settings_change_password_screen")
}