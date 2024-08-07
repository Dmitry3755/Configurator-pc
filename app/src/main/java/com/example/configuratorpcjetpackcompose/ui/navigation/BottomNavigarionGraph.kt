package com.example.configuratorpcjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.configuratorpcjetpackcompose.screens.*
import com.example.configuratorpcjetpackcompose.ui.screens.AccountNavigationScreen
import com.example.configuratorpcjetpackcompose.ui.screens.ConfigurationNavigationScreen
import com.example.configuratorpcjetpackcompose.ui.screens.FavoriteScreen
import com.example.configuratorpcjetpackcompose.ui.screens.SearchScreen
import com.example.configuratorpcjetpackcompose.ui.screens.SettingsThemeScreen

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.ConfigurationScreen.route
    ) {
        composable(route = BottomNavigationItem.ConfigurationScreen.route) {
            ConfigurationNavigationScreen()
        }
        composable(route = BottomNavigationItem.FavoriteScreen.route) {
            FavoriteScreen(navController)
        }
        composable(route = BottomNavigationItem.SearchScreen.route) {
            SearchScreen()
        }
        composable(route = BottomNavigationItem.SettingsScreen.route) {
            SettingsThemeScreen()
        }
        composable(route = BottomNavigationItem.AccountScreen.route) {
            AccountNavigationScreen()
        }
    }
}