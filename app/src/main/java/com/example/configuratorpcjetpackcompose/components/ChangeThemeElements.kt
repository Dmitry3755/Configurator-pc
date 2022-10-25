package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ChangeThemeElements() {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.5f)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                ThemeElement(isTheme = ThemeTypeEnum.Light)
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                ThemeElement(isTheme = ThemeTypeEnum.Dark)
            }

        }
        ThemeElement(isTheme = ThemeTypeEnum.Dark)
    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.5f)
        ) {
            ChangeThemeElements()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        ChangeThemeElements()
    }
}