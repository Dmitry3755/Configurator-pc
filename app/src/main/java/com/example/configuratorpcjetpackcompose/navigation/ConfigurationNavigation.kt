package com.example.configuratorpcjetpackcompose.navigation

sealed class ConfigurationNavigation(val route: String) {
    object ConfiguratorScreen : ConfigurationNavigation("configurator_screen")
    object SmartAdvisorScreen : ConfigurationNavigation("smart_advisor_screen")
    object CreateConfigurationScreen : ConfigurationNavigation("create_configuration_screen")
    object SelectedConfigurationScreen : ConfigurationNavigation("selected_configuration_screen")
}