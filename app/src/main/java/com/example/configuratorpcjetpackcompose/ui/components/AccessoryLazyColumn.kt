package com.example.configuratorpcjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

@Composable
fun AccessoryLazyColumn(
    accessories: List<com.example.data.entities.AccessoryApiResponse>,
    navController: NavController,
    lineType: ConfigurationElementEnum
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        content = {
            items(accessories.size) { index ->
                AccessoryElement(
                    accessories[index],
                    navController,
                    lineType,
                    false
                )
            }
        })
}


@Preview
@Composable
private fun AccessoryLazyColumnPreview() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        AccessoryLazyColumn(
            listOf(
                com.example.data.entities.AccessoryApiResponse(
                    _idAccessory = "",
                    _nameAccessory = "i7",
                    _priceAccessory = 1923.0,
                    _descriptionAccessory = "12dsfert",
                    _categoryAccessoryEnum = com.example.data.entities.CategoryAccessoryEnum.PROCESSOR,
                    _uriAccessory = ""
                )
            ),
            navController = accessoryNavController,
            lineType = ConfigurationElementEnum.Processor
        )
    }
}