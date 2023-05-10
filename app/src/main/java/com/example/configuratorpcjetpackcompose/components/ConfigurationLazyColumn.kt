package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ConfigurationLazyColumn(
    configurationsList: List<Configuration>,
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.mainButtonCornerRadius),
        content = {
            items(configurationsList.size) { index ->
                ShortConfigurationElement(configurationsList[index])
            }
        })
}


@Preview
@Composable
private fun AccessoryLazyColumnPreview() {
    AppTheme() {
        ConfigurationLazyColumn(listOf(Configuration()))
    }
}