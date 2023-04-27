package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.screens.AccessoryNavigationScreen
import com.example.configuratorpcjetpackcompose.screens.AccessoryScreen
import com.example.configuratorpcjetpackcompose.screens.AddUpdateConfigurationScreen
import com.example.configuratorpcjetpackcompose.screens.AllSelectedComponentsScreen
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
        composable(route = AccessoryNavigation.AllSelectedComponentsScreen.route + "/{lineTypeName}") { backStackEntry ->
            val lineType = backStackEntry.arguments?.getString("lineTypeName")
                ?.let { ConfigurationElementEnum.valueOf(it) }
            if (lineType != null) {
                AllSelectedComponentsScreen(lineType = lineType, navController)
            } else {
                AllSelectedComponentsScreen(
                    lineType = ConfigurationElementEnum.Processor,
                    navController
                )
            }
        }
        composable(route = AccessoryNavigation.AccessoryScreen.route + "/{lineTypeName}" + "/{simpleName}" + "/{idAccessory}") { backStackEntry ->
            val idAccessory = backStackEntry.arguments?.getString("idAccessory")!!
            val lineType = backStackEntry.arguments?.getString("lineTypeName")
                ?.let { ConfigurationElementEnum.valueOf(it) }
            val simpleName = backStackEntry.arguments?.getString("simpleName")!!
            if (lineType != null) {
                AccessoryScreen(idAccessory = idAccessory, lineType = lineType, simpleName = simpleName)
            } else {
                AllSelectedComponentsScreen(
                    lineType = ConfigurationElementEnum.Processor,
                    navController
                )
            }
        }
    }
}