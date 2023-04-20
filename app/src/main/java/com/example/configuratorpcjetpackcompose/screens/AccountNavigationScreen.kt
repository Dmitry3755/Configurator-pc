package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.navigation.AccountSettingsNavigationGraph
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AccountNavigationScreen() {
    val accountSettingsNavigation = rememberNavController()
    AccountSettingsNavigationGraph(navController = accountSettingsNavigation)
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        AccountNavigationScreen()
    }
}