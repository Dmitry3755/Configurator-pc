package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.AccessoryLazyColumn
import com.example.configuratorpcjetpackcompose.components.FilterForAccessorySearchableDropdownMenu
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel
import kotlinx.coroutines.launch

@Composable
fun AccessoryScreen(
    lineType: ConfigurationElementEnum
) {

    val viewModel: AccessoryViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    var state by remember { mutableStateOf(false) }
    val loadAccessory = viewModel.listAccessory

    LaunchedEffect(state) {
        coroutineScope.launch() {
            for (accessoriesTypes in lineType.classAccessoriesTypesList) {
                loadAccessory.addAll(viewModel.loadAccessory(accessoriesTypes))
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
            AccessoryLazyColumn(loadAccessory)
        }
    }
}

@Preview
@Composable
private fun AccessoryScreenDefaultPreview() {
    AppTheme() {
        // val viewModel: AccessoryViewModel = viewModel()
        AccessoryScreen(
            ConfigurationElementEnum.Case
        )
    }
}