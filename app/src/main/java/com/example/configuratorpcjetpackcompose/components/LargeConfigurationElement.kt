package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

@Composable
fun LargeConfigurationElement(
    navController: NavController,
    configuration: com.example.configuratorpcjetpackcompose.model.dataclass.Configuration
) {

    Column(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = AppTheme.colors.backgroundButtonColor
            )
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        for (elementType in ConfigurationElementEnum.values()) {
            Row() {
                LargeConfigurationElementLine(
                    configurationElement = elementType,
                    navController = navController,
                   isAccessoryAdded = configuration.checkAccessoryInConfiguration(elementType.classAccessoriesTypesList)
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        LargeConfigurationElement(
            accessoryNavController,
            com.example.configuratorpcjetpackcompose.model.dataclass.Configuration()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        LargeConfigurationElement(
            accessoryNavController,
            com.example.configuratorpcjetpackcompose.model.dataclass.Configuration()
        )
    }
}