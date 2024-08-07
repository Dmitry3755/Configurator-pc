package com.example.configuratorpcjetpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.components.AccessoryLazyColumn
import com.example.configuratorpcjetpackcompose.components.FilterForAccessorySearchableDropdownMenu
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel
import kotlinx.coroutines.launch

@Composable
fun AllSelectedComponentsScreen(
    lineType: ConfigurationElementEnum,
    navController: NavController
) {

    val viewModel: AccessoriesViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val loadAccessory = viewModel.listAccessory

    LaunchedEffect(coroutineScope) {
        coroutineScope.launch() {
            if(loadAccessory.isEmpty()) {
                for (accessoriesTypes in lineType.classAccessoriesTypesList) {
                    loadAccessory.addAll(viewModel.loadAccessory(accessoriesTypes))
                }
            }
        }
    }

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
            HeadersTextView(text = lineType.contentDescription)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.1f)
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding
                ),
        ) {
            FilterForAccessorySearchableDropdownMenu()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.75f)
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding
                ),
            contentAlignment = Alignment.BottomStart
        ) {
            AccessoryLazyColumn(loadAccessory, navController, lineType)
        }
    }
}

@Preview
@Composable
private fun AllSelectedComponentsScreenDefaultPreview() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        AllSelectedComponentsScreen(
            ConfigurationElementEnum.Processor,
            accessoryNavController,
        )
    }
}