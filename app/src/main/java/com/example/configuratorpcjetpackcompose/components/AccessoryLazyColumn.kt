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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum

@Composable
fun AccessoryLazyColumn(
    accessories: List<Accessory>,
    navController: NavController,
    lineType: ConfigurationElementEnum
) {

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
                Accessory(
                    _idAccessory = "",
                    _nameAccessory = "i7",
                    _priceAccessory = 1923.0,
                    _descriptionAccessory = "12dsfert",
                    _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                    _uriAccessory = ""
                )
            ),
            navController = accessoryNavController,
            lineType = ConfigurationElementEnum.Processor
        )
    }
}