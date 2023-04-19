package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AccessoryLazyColumn(accessories: List<Accessory>) {

    val lineColor = AppTheme.colors.backgroundButtonColor
    val isCollapsed = remember {
        mutableStateOf(true)
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        content = {
            items(accessories.size) { index ->
                    AccessoryElement(accessories[index])
            }
        })
}


@Preview
@Composable
private fun AccessoryLazyColumnPreview() {
    AppTheme() {
        AccessoryLazyColumn(
            listOf(
                Accessory(
                    nameAccessory = "i7",
                    priceAccessory = 1923.0,
                    descriptionAccessory = "12dsfert",
                    categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                    uriAccessory = ""
                )
            )
        )
    }
}