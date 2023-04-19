package com.example.configuratorpcjetpackcompose.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.utils.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun ChangeThemeElements(selectedTheme: MutableState<ThemeTypeEnum>) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.5f)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                ThemeElement(isTheme = ThemeTypeEnum.Light, selectedTheme)
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                ThemeElement(isTheme = ThemeTypeEnum.Dark, selectedTheme)
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
        ) {
            ThemeElement(isTheme = ThemeTypeEnum.System, selectedTheme)
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable

private fun DefaultPreviewLight() {
    AppTheme() {
        val viewModel: AppViewModel = viewModel()
            ChangeThemeElements(viewModel.selectedTheme)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        val viewModel: AppViewModel = viewModel()
        ChangeThemeElements(viewModel.selectedTheme)
    }
}