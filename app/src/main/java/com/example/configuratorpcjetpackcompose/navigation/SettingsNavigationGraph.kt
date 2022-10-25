package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.screens.*

@Composable
fun SettingsNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SettingsNavigation.SettingsScreen.route
    ){
        composable(route = SettingsNavigation.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}