package com.example.configuratorpcjetpackcompose.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.ConfigurationAlertDialog
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.LargeConfigurationElement
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel
import kotlinx.coroutines.launch

@Composable
fun AddUpdateConfigurationScreen(
    navController: NavController,
    accessoriesViewModel: AccessoriesViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val saveResultViewError = remember { mutableStateOf(ConfigurationError()) }

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
                        navController = navController,
                        configuration = accessoriesViewModel.configuration.value,
                        viewModel = accessoriesViewModel
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
                        onClick = {
                            coroutineScope.launch {
                                saveResultViewError.value = accessoriesViewModel.configuration.value.checkingCompatibility()
                                if(!saveResultViewError.value.isError.value) {
                                    accessoriesViewModel.saveConfiguration(accessoriesViewModel.configuration.value)
                                }
                            }
                        },
                        isDelete = false
                    )
                }
                if(saveResultViewError.value.isError.value){
                    ConfigurationAlertDialog(saveResultViewError = saveResultViewError)
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
        AddUpdateConfigurationScreen(accessoryNavController)
    }
}