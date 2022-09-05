package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colors.backgroundMainScreenColor
            )
            .fillMaxSize()
    ) {

    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        SearchScreen()
    }
}