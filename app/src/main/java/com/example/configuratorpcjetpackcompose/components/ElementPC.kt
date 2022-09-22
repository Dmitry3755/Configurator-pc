package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun ElementPC(configurationItem: ConfigurationElement) {
    val selectedItem = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(
            top = AppTheme.dimensions.configurationElementsPadding,
            bottom = AppTheme.dimensions.configurationElementsPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .border(
                    border = BorderStroke(2.dp, AppTheme.colors.borderConfigurationColor),
                    shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                )
                .size(60.dp)
                .background(
                    color = colorResource(id = configurationItem.color),
                    shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp)
                ),
            painter = painterResource(id = configurationItem.icon),
            contentDescription = configurationItem.contentDescription,
            tint = Color.Unspecified
        )
        IconToggleButton(
            checked = selectedItem.value,
            onCheckedChange = { },
            modifier = Modifier.size(25.dp)
        ) {
            Icon(
                painter = painterResource(
                    if (selectedItem.value) {
                        R.drawable.ic_checkmark
                    } else {
                        R.drawable.ic_circle_outline
                    }
                ),
                contentDescription = null,
                tint = AppTheme.colors.borderConfigurationColor
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreviewLight() {
    AppTheme {
        ElementPC(ConfigurationElement.Processor)
    }
}