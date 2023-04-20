package com.example.configuratorpcjetpackcompose.navigation

sealed class AccountSettingsNavigation(val route: String) {
        object AccountScreen : AccountSettingsNavigation("account_screen")
        object SettingsChangePasswordScreen : AccountSettingsNavigation("settings_change_password_screen")
}