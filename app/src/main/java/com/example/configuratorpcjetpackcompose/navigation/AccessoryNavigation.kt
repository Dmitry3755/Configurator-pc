package com.example.configuratorpcjetpackcompose.navigation

sealed class AccessoryNavigation(val route: String) {
    object AccessoryNavigationScreen : Navigation("accessory_navigation_screen")
    object AddUpdateConfigurationScreen : Navigation("add_update_configuration_screen")
    object AllSelectedComponentsScreen : Navigation("all_selected_components_screen")
    object AccessoryScreen : Navigation("accessory_screen")
}