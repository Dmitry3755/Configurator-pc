package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.screens.AddUpdateConfigurationScreen
import com.example.configuratorpcjetpackcompose.screens.ConfiguratorScreen
import com.example.configuratorpcjetpackcompose.screens.SettingsScreen
import com.example.configuratorpcjetpackcompose.screens.SettingsThemeScreen

@Composable
fun ConfigurationNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ConfigurationNavigation.ConfiguratorScreen.route
    ){
        composable(route = ConfigurationNavigation.ConfiguratorScreen.route) {
            ConfiguratorScreen(navController = navController)
        }
        composable(route = ConfigurationNavigation.CreateConfigurationScreen.route){
            AddUpdateConfigurationScreen()
        }
        composable(route = ConfigurationNavigation.SmartAdvisorScreen.route){

        }
    }
}