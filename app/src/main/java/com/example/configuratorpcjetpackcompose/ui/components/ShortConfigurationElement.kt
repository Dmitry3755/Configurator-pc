package com.example.configuratorpcjetpackcompose.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.R
import com.example.data.model.entities.data_class.Configuration
import com.example.configuratorpcjetpackcompose.ui.navigation.ConfigurationNavigation
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun ShortConfigurationElement(
    configuration: com.example.data.model.entities.data_class.Configuration,
    navController: NavController,
    accessoriesViewModel: AccessoriesViewModel = viewModel()
) {
    val lineColor = AppTheme.colors.backgroundButtonColor
    val configurationItems = listOf(
        ConfigurationElementEnum.Processor to 0,
        ConfigurationElementEnum.Motherboard to 1,
        ConfigurationElementEnum.Ram to 2,
        ConfigurationElementEnum.PowerSupplyUnit to 3,
        ConfigurationElementEnum.SoundCard to 4,
        ConfigurationElementEnum.VideoCard to 5,
        ConfigurationElementEnum.Cooler to 6,
        ConfigurationElementEnum.DataStorage to 7,
        ConfigurationElementEnum.Case to 8,
        ConfigurationElementEnum.Monitor to 9
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(IntrinsicSize.Min)
            .clickable {
                accessoriesViewModel.selectConfiguration(configuration)
                navController.navigate(ConfigurationNavigation.SelectedConfigurationScreen.route)
            }
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Transparent
                )
                .border(
                    border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                    shape = RoundedCornerShape(15.dp)
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth(1f)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .drawBehind {
                            drawLine(
                                color = lineColor,
                                start = Offset(
                                    x = 0f,
                                    y = size.height
                                ),
                                end = Offset(
                                    x = size.width,
                                    y = size.height
                                ),
                                strokeWidth = 2.dp.toPx()
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                top = 5.dp,
                                start = 15.dp
                            ),
                        text = configuration.nameConfiguration,
                        style = AppTheme.typography.text,
                        color = AppTheme.colors.textMainColor
                    )
                    Icon(
                        modifier = Modifier
                            .padding(
                                top = 1.dp,
                                bottom = 1.dp,
                                end = 15.dp
                            )
                            .clickable {

                            },
                        painter = if (configuration.isFavorite) {
                            painterResource(id = R.drawable.ic_favorite)
                        } else {
                            painterResource(id = R.drawable.ic_not_favorite)
                        },
                        contentDescription = "",
                        tint = AppTheme.colors.backgroundButtonColor
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    configurationItems.filter { (item, value) -> value < 5 }
                        .forEach { item ->
                            ElementPC(
                                configurationItem = item.first,
                                selectedItem = configuration.isNotEmptyAccessoryInConfiguration(item.first.classAccessoriesTypesList)
                            )
                        }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    configurationItems.filter { (item, value) -> value > 4 }
                        .forEach { item ->
                            ElementPC(
                                configurationItem = item.first,
                                selectedItem = configuration.isNotEmptyAccessoryInConfiguration(item.first.classAccessoriesTypesList)
                            )
                        }
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme {
        val navController: NavController = rememberNavController()
        ShortConfigurationElement(com.example.data.model.entities.data_class.Configuration(), navController)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme {
        val navController: NavController = rememberNavController()
        ShortConfigurationElement(com.example.data.model.entities.data_class.Configuration(), navController)
    }
}