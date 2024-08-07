package com.example.configuratorpcjetpackcompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.components.BottomNavigationBar
import com.example.configuratorpcjetpackcompose.ui.navigation.BottomNavigationGraph
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainNavigationScreen() {
    val bottomNavigationNavController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavigationNavController) },
        content = { padding ->
            Box(
                modifier = Modifier.padding(padding)
            ) {
                BottomNavigationGraph(navController = bottomNavigationNavController)
            }
        },
        backgroundColor = AppTheme.colors.backgroundMainScreenColor
    )
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        MainNavigationScreen()
    }
}