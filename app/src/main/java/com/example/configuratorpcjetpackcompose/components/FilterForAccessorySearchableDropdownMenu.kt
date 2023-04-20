package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.utils.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.utils.ViewError

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterForAccessorySearchableDropdownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val searchResultViewError = remember { mutableStateOf(ViewError()) }
    var value = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(1f)
        ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset.Zero
        ) {

        }
    }
}

@Preview
@Composable
fun FilterMenuForAccessoryPreview() {
    AppTheme() {
        FilterForAccessorySearchableDropdownMenu()
    }
}