package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colors.backgroundMainScreenColor
            )
            .fillMaxSize()
    ) {
        HeadersTextView(text = stringResource(id = R.string.navigation_bar_text_view_settings))
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        SettingsScreen()
    }
}