package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigationGraph

@Composable
fun AccessoryNavigationScreen() {
    val accessoryNavController = rememberNavController()
    AccessoryNavigationGraph(navController = accessoryNavController)
}