package com.example.configuratorpcjetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.navigation.ConfigurationNavigationGraph

@Composable
fun ConfigurationNavigationScreen() {
    val configurationNavController = rememberNavController()
    ConfigurationNavigationGraph(navController = configurationNavController)
}