package com.example.configuratorpcjetpackcompose.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.LargeConfigurationElement
import com.example.configuratorpcjetpackcompose.components.LargeConfigurationElementLine
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun AddUpdateConfigurationScreen(
    navController: NavController,
    viewModel: AccessoryViewModel
) {
    val viewModel: AccessoryViewModel = viewModel()

    Column(
        modifier = Modifier
            .background(color = AppTheme.colors.backgroundMainScreenColor)
            .fillMaxSize(1f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.15f)
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding
                ),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.configurator_text_view_new_configuration))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.85f),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .weight(0.85f),
                    contentAlignment = Alignment.Center
                ) {
                    LargeConfigurationElement(
                        viewModel,
                        navController = navController
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .weight(0.15f)
                        .padding(
                            start =
                            AppTheme.dimensions.textViewPadding,
                            bottom = 10.dp,
                            end = AppTheme.dimensions.textViewPadding
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    MainButton(
                        stringResource(id = R.string.configurator_text_view_save_configuration),
                        onClick = {},
                        isDelete = false
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        val viewModel: AccessoryViewModel = viewModel()
        AddUpdateConfigurationScreen(accessoryNavController, viewModel)
    }
}