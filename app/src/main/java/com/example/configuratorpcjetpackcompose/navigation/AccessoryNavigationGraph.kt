package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.screens.AccessoryNavigationScreen
import com.example.configuratorpcjetpackcompose.screens.AccessoryScreen
import com.example.configuratorpcjetpackcompose.screens.AddUpdateConfigurationScreen
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel

@Composable
fun AccessoryNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AccessoryNavigation.AddUpdateConfigurationScreen.route
    ) {
        composable(route = AccessoryNavigation.AddUpdateConfigurationScreen.route) { backStackEntry ->
            val viewModel: AccessoryViewModel = viewModel(backStackEntry)
            AddUpdateConfigurationScreen(navController, viewModel)
        }
        composable(route = AccessoryNavigation.AccessoryNavigationScreen.route) {
            AccessoryNavigationScreen()
        }
        composable(route = AccessoryNavigation.AccessoryScreen.route + "/{lineTypeName}") { backStackEntry ->
            val lineType = backStackEntry.arguments?.getString("lineTypeName")
                ?.let { ConfigurationElementEnum.valueOf(it) }
            if (lineType != null) {
                AccessoryScreen(lineType = lineType)
            } else {
                AccessoryScreen(lineType = ConfigurationElementEnum.Processor)
            }
        }
    }
}