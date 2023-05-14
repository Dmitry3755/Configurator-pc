package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.screens.*
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun ConfigurationNavigationGraph(navController: NavHostController) {

    val viewModel: AccessoriesViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ConfigurationNavigation.ConfiguratorScreen.route
    ){
        composable(route = ConfigurationNavigation.ConfiguratorScreen.route) {
            ConfiguratorScreen(navController = navController, viewModel)
        }
        composable(route = ConfigurationNavigation.CreateConfigurationScreen.route){
            AccessoryNavigationScreen()
        }
        composable(route = ConfigurationNavigation.SelectedConfigurationScreen.route){
            SelectedConfigurationScreen(navController, viewModel)
        }
        composable(route = ConfigurationNavigation.SmartAdvisorScreen.route){

        }
    }
}