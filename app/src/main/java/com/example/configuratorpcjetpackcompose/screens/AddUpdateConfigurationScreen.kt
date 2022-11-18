package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.components.LargeConfigurationElement
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun AddUpdateConfigurationScreen() {
    val viewModel: AppViewModel = viewModel()
    LargeConfigurationElement(viewModel)
}