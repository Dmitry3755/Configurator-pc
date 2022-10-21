package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.screens.SettingsThemeScreen
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ChangeThemeElements() {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            ThemeElement(isTheme = ThemeTypeEnum.Light)
            ThemeElement(isTheme = ThemeTypeEnum.Dark)
        }
        ThemeElement(isTheme = ThemeTypeEnum.Dark)
    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        ChangeThemeElements()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        ChangeThemeElements()
    }
}