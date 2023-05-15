package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.configuratorpcjetpackcompose.components.ConfigurationLazyColumn
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel
import com.example.configuratorpcjetpackcompose.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun FavoriteScreen(
    navController: NavController,
    accessoriesViewModel: AccessoriesViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val stateLoadingUserConfiguration = remember {
        mutableStateOf(false)
    }
    var userConfigurationsList = accessoriesViewModel.userConfigurationsList

    LaunchedEffect(coroutineScope) {
        coroutineScope.launch {
            accessoriesViewModel.loadAllConfigurationsForUser()
            if (userConfigurationsList.isNotEmpty()) {
                stateLoadingUserConfiguration.value = true
            }
        }
    }

    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colors.backgroundMainScreenColor
            )
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    start = 30.dp
                )
                .weight(0.15f),
            contentAlignment = Alignment.BottomEnd
        ) {
            HeadersTextView(text = stringResource(id = R.string.navigation_bar_text_view_favorite))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.85f),
            contentAlignment = Alignment.Center
        ) {
            if (stateLoadingUserConfiguration.value) {
                ConfigurationLazyColumn(userConfigurationsList, navController, accessoriesViewModel)
            } else {
                Text(
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.textMainColor,
                    style = AppTheme.typography.text,
                    text = stringResource(id = R.string.configurator_text_view_have_not_configurations)
                )
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        FavoriteScreen(navController)
    }
}