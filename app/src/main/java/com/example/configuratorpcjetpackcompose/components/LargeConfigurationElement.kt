package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun LargeConfigurationElement(
    navController: NavController,
    configuration: com.example.configuratorpcjetpackcompose.model.data_class.Configuration,
    viewModel: AccessoriesViewModel = viewModel()
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = AppTheme.colors.backgroundButtonColor
            )
            .verticalScroll(scrollState)
    ) {
        for (elementType in ConfigurationElementEnum.values()) {
            var isDeleted = remember {
                mutableStateOf(false)
            }
            Row {
                key(isDeleted.value) {
                    LargeConfigurationElementLine(
                        configurationElement = elementType,
                        navController = navController,
                        configuration = configuration,
                        isAccessoryAdded = configuration.checkAccessoryInConfiguration(elementType.classAccessoriesTypesList),
                        viewModel = viewModel,
                        isDeleted = isDeleted
                    )
                }
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
            com.example.configuratorpcjetpackcompose.model.data_class.Configuration()
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
            com.example.configuratorpcjetpackcompose.model.data_class.Configuration()
        )
    }
}