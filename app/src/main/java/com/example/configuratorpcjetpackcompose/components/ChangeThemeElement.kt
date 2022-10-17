package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.SettingsThemeTypeEnum
import com.example.configuratorpcjetpackcompose.screens.SettingsScreen
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ChangeThemeElement(isTheme: SettingsThemeTypeEnum) {

    val darkTheme: Boolean = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(
                when (isTheme) {
                    SettingsThemeTypeEnum.isLight -> R.string.settings_change_element_light
                    SettingsThemeTypeEnum.isDark -> R.string.settings_change_element_dark
                    else -> R.string.settings_change_element_system
                }
            ),
            style = AppTheme.typography.buttonText,
            color = AppTheme.colors.textMainColor
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f)
                .fillMaxHeight(0.2f)
                .background(
                    color =
                    when (isTheme) {
                        SettingsThemeTypeEnum.isLight -> com.example.configuratorpcjetpackcompose.ui.theme.White
                        SettingsThemeTypeEnum.isDark -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                        else -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                    },
                    shape = RoundedCornerShape(AppTheme.dimensions.roundedCornerShape)
                )
                .border(
                    border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                    shape = RoundedCornerShape(AppTheme.dimensions.roundedCornerShape)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.text),
                style = AppTheme.typography.buttonText,
                color =
                when (isTheme) {
                    SettingsThemeTypeEnum.isLight -> com.example.configuratorpcjetpackcompose.ui.theme.Black
                    SettingsThemeTypeEnum.isDark -> com.example.configuratorpcjetpackcompose.ui.theme.White
                    else -> com.example.configuratorpcjetpackcompose.ui.theme.White
                }
            )
        }
        Spacer(modifier = Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        IconToggleButton(
            checked =
            when (isTheme) {
                SettingsThemeTypeEnum.isLight -> true
                SettingsThemeTypeEnum.isDark -> true
                else -> true
            },
            onCheckedChange = { },
            modifier = Modifier.size(25.dp)
        ) {
            Icon(
                painter = painterResource(
                    when (isTheme) {
                        SettingsThemeTypeEnum.isLight -> R.drawable.ic_checkmark
                        SettingsThemeTypeEnum.isDark -> R.drawable.ic_checkmark
                        else -> R.drawable.ic_checkmark
                    }
                ),
                contentDescription = null,
                tint = AppTheme.colors.backgroundButtonColor
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme {
        ChangeThemeElement(SettingsThemeTypeEnum.isLight)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewSystem() {
    AppTheme {
        ChangeThemeElement(SettingsThemeTypeEnum.isSystem)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme {
        ChangeThemeElement(SettingsThemeTypeEnum.isDark)
    }
}