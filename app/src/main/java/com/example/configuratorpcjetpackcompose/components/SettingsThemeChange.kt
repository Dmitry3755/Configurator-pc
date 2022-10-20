package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.SettingsThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun SettingsThemeChange() {

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                color = AppTheme.colors.backgroundMainScreenColor
            ),
        Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                ThemeElement(ThemeTypeEnum.Light)
                ThemeElement(ThemeTypeEnum.Dark)
            }
            Spacer(modifier = Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            ThemeElement(ThemeTypeEnum.System)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme {
        SettingsThemeChange()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme {
        SettingsThemeChange()
    }
}