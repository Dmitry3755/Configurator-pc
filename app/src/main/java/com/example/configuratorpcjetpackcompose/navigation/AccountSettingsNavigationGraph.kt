package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.screens.SettingsChangePasswordScreen
import com.example.configuratorpcjetpackcompose.screens.*

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