package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.screens.*

@Composable
fun SettingsNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SettingsNavigation.SettingsScreen.route
    ){
        composable(route = SettingsNavigation.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = SettingsNavigation.SettingsThemeScreen.route){
            SettingsThemeScreen()
        }
        composable(route = SettingsNavigation.SettingsChangePasswordScreen.route){
            SettingsChangePasswordScreen()
        }
    }
}