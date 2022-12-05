package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun LargeConfigurationElement(viewModel: AppViewModel) {

    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = AppTheme.colors.backgroundButtonColor
        )
    ) {
        for ((index, elementType) in ConfigurationElementEnum.values()
            .withIndex()) {
            Row() {
                LargeConfigurationElementLine(
                    lineType = elementType,
                    selectedAccessoriesList = viewModel.configurationPc[index],
                    viewModel = viewModel
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        LargeConfigurationElement(viewModel = viewModel())
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        LargeConfigurationElement(viewModel = viewModel())
    }
}