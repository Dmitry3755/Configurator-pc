package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.navigation.ConfigurationNavigationGraph

@Composable
fun ConfigurationNavigationScreen() {
    val configurationNavController = rememberNavController()
    ConfigurationNavigationGraph(navController = configurationNavController)
}