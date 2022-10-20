package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .background(color = AppTheme.colors.backgroundMainScreenColor)
            .fillMaxSize(1f)
            .padding(
                start =
                AppTheme.dimensions.textViewPadding,
                bottom = 10.dp,
                end = AppTheme.dimensions.textViewPadding
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.15f),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.navigation_bar_text_view_settings))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.85f),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                MainButton(
                    stringResource(id = R.string.settings_button_setting_theme),
                    onClick = {},
                    isDelete = false
                )
                Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
                MainButton(
                    stringResource(id = R.string.settings_button_change_name),
                    onClick = {},
                    isDelete = false
                )
                Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
                MainButton(
                    stringResource(id = R.string.settings_button_change_password),
                    onClick = {

                    },
                    isDelete = false
                )
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        SettingsScreen()
    }
}