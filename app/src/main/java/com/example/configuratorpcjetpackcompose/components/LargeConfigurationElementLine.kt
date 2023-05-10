package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun LargeConfigurationElementLine(
    configurationElement: ConfigurationElementEnum,
    navController: NavController,
    isAccessoryAdded: Boolean,
    configuration: com.example.configuratorpcjetpackcompose.model.data_class.Configuration,
    viewModel: AccessoriesViewModel = viewModel()
) {
    val lineColor = AppTheme.colors.backgroundButtonColor
    val isCollapsed = remember {
        mutableStateOf(true)
    }
    var text = remember {
        mutableStateOf("")
    }

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .drawBehind {
                    drawLine(
                        color = lineColor,
                        start = Offset(
                            x = 0f,
                            y = 0f
                        ),
                        end = Offset(
                            x = size.width,
                            y = 0f
                        ),
                        strokeWidth = 2.dp.toPx()
                    )
                    if (isCollapsed.value) {
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
                    }
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = configurationElement.contentDescription,
                modifier = Modifier.fillMaxWidth(0.3f),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.text
            )
            Icon(
                modifier = Modifier
                    .padding(vertical = AppTheme.dimensions.configurationElementsPadding)
                    .border(
                        border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(60.dp)
                    .background(
                        color = colorResource(id = configurationElement.color),
                        shape = RoundedCornerShape(12.dp)
                    ),
                painter = painterResource(id = configurationElement.icon),
                contentDescription = configurationElement.contentDescription,
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier.height(20.dp),
                painter = painterResource(
                    if (isAccessoryAdded) {
                        R.drawable.ic_checkmark //TODO: Заменить иконку в соответствии с дизайном
                    } else {
                        R.drawable.ic_circle_outline
                    }
                ),
                contentDescription = null,
                tint = AppTheme.colors.backgroundButtonColor
            )

            if (!isAccessoryAdded) {
                MainButton(
                    textButton = stringResource(id = R.string.btn_text_add),
                    onClick = {
                        navController.navigate(AccessoryNavigation.AllSelectedComponentsScreen.route + "/${configurationElement.name}")
                    },
                    isSmall = true
                )
            } else {
                IconButton(
                    modifier = Modifier.fillMaxWidth(0.55f), //TODO: Исправить
                    onClick = {
                        isCollapsed.value = !isCollapsed.value
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_down_arrow),
                        contentDescription = stringResource(id = R.string.btn_text_add)
                    )
                }
            }
        }

        Row {
            if (isAccessoryAdded && !isCollapsed.value) {
                Column(
                    modifier = Modifier.background(AppTheme.colors.backgroundFormColor),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    for (item in configurationElement.classAccessoriesTypesList) {
                        if (configuration.getListAccessoryFromConfiguration(
                                item
                            ).isNotEmpty()
                        ) {
                            for (accessoryListItem in configuration.getListAccessoryFromConfiguration(
                                item
                            )) {
                                text.value = accessoryListItem._nameAccessory
                                AccessoryAddedOnConfiguration(
                                    configuration = configuration,
                                    text = text.value,
                                    accessory = item,
                                    navController = navController,
                                    configurationElement = configurationElement
                                )
                            }
                        } else {
                            text.value =
                                configuration.getAccessoryFromConfiguration(item)._nameAccessory
                            AccessoryAddedOnConfiguration(
                                configuration = configuration,
                                text = text.value,
                                accessory = item,
                                navController = navController,
                                configurationElement = configurationElement
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        LargeConfigurationElementLine(
            configurationElement = ConfigurationElementEnum.Processor,
            accessoryNavController,
            configuration = com.example.configuratorpcjetpackcompose.model.data_class.Configuration(),
            isAccessoryAdded = false
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        LargeConfigurationElementLine(
            configurationElement = ConfigurationElementEnum.Motherboard,
            accessoryNavController,
            configuration = com.example.configuratorpcjetpackcompose.model.data_class.Configuration(),
            isAccessoryAdded = true
        )
    }
}