package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.R

@Composable
fun ShortConfigurationElement() {
    var lineColor = AppTheme.colors.borderConfigurationColor
    val configurationItems = listOf(
        ConfigurationElement.Processor to 0,
        ConfigurationElement.MatherBoard to 1,
        ConfigurationElement.RAM to 2,
        ConfigurationElement.PowerSupplyUnit to 3,
        ConfigurationElement.SoundCard to 4,
        ConfigurationElement.VideoCard to 5,
        ConfigurationElement.Cooler to 6,
        ConfigurationElement.DataStorage to 7,
        ConfigurationElement.Case to 8,
        ConfigurationElement.Monitor to 9
    )

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Transparent
                )
                .border(
                    border = BorderStroke(2.dp, AppTheme.colors.borderConfigurationColor),
                    shape = RoundedCornerShape(30.dp, 30.dp, 30.dp, 30.dp)
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth(1f)
        ) {
            Column  {
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
                        text = "Name",
                        style = AppTheme.typography.text,
                        color = AppTheme.colors.textMainColor
                    )
                    Icon(
                        modifier = Modifier
                            .padding(
                                top = 1.dp,
                                bottom = 1.dp,
                                end = 15.dp
                            ),
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "",
                        tint = AppTheme.colors.borderConfigurationColor
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    configurationItems.filter { (item, value) -> value < 5 }
                        .forEach { item ->
                            ElementPC(configurationItem = item.first)
                        }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    configurationItems.filter { (item, value) -> value > 4 }
                        .forEach { item ->
                            ElementPC(configurationItem = item.first)
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
        ShortConfigurationElement()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme {
        ShortConfigurationElement()
    }
}