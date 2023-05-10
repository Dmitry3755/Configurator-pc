package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.*
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.navigation.ConfigurationNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ConfiguratorScreen(navController: NavController) {
    val accessoriesViewModel: AccessoriesViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    var userConfigurationsList = accessoriesViewModel.userConfigurationsList


    LaunchedEffect(coroutineScope) {
        coroutineScope.launch {
            accessoriesViewModel.loadAllConfigurationsForUser()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.15f)
                .padding(start = 30.dp, bottom = 10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.configurator_text_view_title_configurator))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.85f),
            contentAlignment = Alignment.Center
        ) {
            ConfigurationLazyColumn(userConfigurationsList)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = AppTheme.dimensions.buttonPadding
            )
        ) {
            MainButton(
                stringResource(id = R.string.configurator_text_view_smart_advisor),
                onClick = {

                },
                isDelete = false
            )
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            MainButton(
                stringResource(id = R.string.configurator_text_view_create_configuration),
                onClick = {
                    navController.navigate(ConfigurationNavigation.CreateConfigurationScreen.route)
                },
                isDelete = false
            )
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        ConfiguratorScreen(navController)
    }
}