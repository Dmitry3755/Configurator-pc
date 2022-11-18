package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel
import com.example.configuratorpcjetpackcompose.viewmodel.AuthenticationViewModel

@Composable
fun LargeConfigurationElement(viewModel: AppViewModel) {

    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = AppTheme.colors.backgroundButtonColor
        )
    ) {
        for ((index, elementType) in ConfigurationElement::class.nestedClasses.map { it.objectInstance as ConfigurationElement }
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