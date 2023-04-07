package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel

@Composable
fun AccessoryElementLine(
    price: Double,
    name: String
) {

    val lineColor = AppTheme.colors.backgroundButtonColor
    val isCollapsed = remember {
        mutableStateOf(true)
    }

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
            }
            .padding(5.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            modifier = Modifier.fillMaxWidth(0.45f),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.text
        )
        Text(
            text = price.toString() + " ₽",
            modifier = Modifier.fillMaxWidth(0.55f),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.text
        )
    }

}

@Preview
@Composable
fun AccessoryElementLinePreview() {
    AppTheme() {
        AccessoryElementLine(price = 35000.0, name = "Intel Core i7-13700K")
    }
}