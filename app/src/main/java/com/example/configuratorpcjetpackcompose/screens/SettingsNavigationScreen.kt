package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.navigation.SettingsNavigationGraph
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun SettingsNavigationScreen() {
    val settingsNavController = rememberNavController()
    SettingsNavigationGraph(navController = settingsNavController)
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        SettingsNavigationScreen()
    }
}