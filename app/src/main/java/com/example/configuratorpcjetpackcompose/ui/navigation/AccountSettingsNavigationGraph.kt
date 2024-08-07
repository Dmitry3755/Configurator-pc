package com.example.configuratorpcjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.ui.screens.SettingsChangePasswordScreen
import com.example.configuratorpcjetpackcompose.screens.*
import com.example.configuratorpcjetpackcompose.ui.screens.AccountScreen

@Composable
fun AccountSettingsNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AccountSettingsNavigation.AccountScreen.route
    ){
        composable(route = AccountSettingsNavigation.AccountScreen.route) {
            AccountScreen(navController = navController)
        }
        composable(route = AccountSettingsNavigation.SettingsChangePasswordScreen.route){
            SettingsChangePasswordScreen()
        }
    }
}