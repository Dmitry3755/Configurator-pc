package com.example.configuratorpcjetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.navigation.AccessoryNavigationGraph

@Composable
fun AccessoryNavigationScreen() {
    val accessoryNavController = rememberNavController()
    AccessoryNavigationGraph(navController = accessoryNavController)
}