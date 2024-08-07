package com.example.configuratorpcjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.screens.LogInScreen
import com.example.configuratorpcjetpackcompose.ui.screens.MainNavigationScreen
import com.example.configuratorpcjetpackcompose.ui.screens.SingUpScreen
import com.example.configuratorpcjetpackcompose.ui.screens.StartMainScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navigation.StartMainScreen.route) {
        composable(route = Navigation.StartMainScreen.route) {
            StartMainScreen(navController = navController)
        }
        composable(route = Navigation.SingUpScreen.route) {
            SingUpScreen(navController = navController)
        }
        composable(route = Navigation.LogInScreen.route) {
            LogInScreen(navController = navController)
        }
        composable(route = Navigation.MainNavigationScreen.route) {
            MainNavigationScreen()
        }
    }
}