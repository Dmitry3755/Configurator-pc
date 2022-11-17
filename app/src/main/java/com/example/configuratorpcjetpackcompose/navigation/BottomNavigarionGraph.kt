package com.example.configuratorpcjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.screens.*

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.ConfigurationScreen.route
    ) {
        composable(route = BottomNavigationItem.ConfigurationScreen.route) {
            ConfiguratorScreen()
        }
        composable(route = BottomNavigationItem.FavoriteScreen.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavigationItem.SearchScreen.route) {
            SearchScreen()
        }
        composable(route = BottomNavigationItem.SettingsScreen.route) {
            SettingsNavigationScreen()
        }
        composable(route = BottomNavigationItem.AccountScreen.route) {
            AccountScreen()
        }
    }
}