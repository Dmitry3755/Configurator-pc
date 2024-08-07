package com.example.configuratorpcjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ViewError

@Composable
fun FilterForAccessorySearchableDropdownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val searchResultViewError = remember { mutableStateOf(ViewError()) }
    var value = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = DpOffset.Zero
            ) {
                
            }
            FilterPriceButton()
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