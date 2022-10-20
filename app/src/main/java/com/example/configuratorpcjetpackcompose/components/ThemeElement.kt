package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ThemeElement(isTheme: ThemeTypeEnum) {

    val selectedItem = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(
                when (isTheme) {
                    ThemeTypeEnum.Light -> R.string.settings_theme_change_light
                    ThemeTypeEnum.Dark -> R.string.settings_theme_change_dark
                    else -> R.string.settings_theme_change_system
                }
            ),
            style = AppTheme.typography.buttonText,
            color = AppTheme.colors.textMainColor
        )
        Spacer(modifier = Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f)
                .fillMaxHeight(0.2f)
                .background(
                    color = when (isTheme) {
                        ThemeTypeEnum.Light -> com.example.configuratorpcjetpackcompose.ui.theme.White
                        ThemeTypeEnum.Dark -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                        else -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                    },
                    shape = RoundedCornerShape(30.dp)
                )
                .border(
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.text),
                style = AppTheme.typography.buttonText,
                color = when (isTheme) {
                    ThemeTypeEnum.Light -> com.example.configuratorpcjetpackcompose.ui.theme.Black
                    ThemeTypeEnum.Dark -> com.example.configuratorpcjetpackcompose.ui.theme.White
                    else -> com.example.configuratorpcjetpackcompose.ui.theme.White
                }
            )
        }
        Spacer(modifier = Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        IconToggleButton(
            checked = true,
            onCheckedChange = {},
            modifier = Modifier.size(AppTheme.dimensions.iconToggleButtonSize)
        ) {
            Icon(
                painter = painterResource(
                    if (selectedItem.value) {
                        R.drawable.ic_checkmark
                    } else {
                        R.drawable.ic_circle_outline
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
    AppTheme() {
        ThemeElement(ThemeTypeEnum.Light)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        ThemeElement(ThemeTypeEnum.Dark)
    }
}