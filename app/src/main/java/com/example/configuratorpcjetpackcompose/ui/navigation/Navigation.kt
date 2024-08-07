package com.example.configuratorpcjetpackcompose.ui.navigation

sealed class Navigation(val route: String) {
    object SingUpScreen : Navigation("sing_up_screen")
    object LogInScreen : Navigation("log_in_screen")
    object MainNavigationScreen : Navigation("main_navigation_screen")
    object StartMainScreen : Navigation("start_main_screen")
}