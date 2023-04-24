package com.example.configuratorpcjetpackcompose.components

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun FilterPriceButton() {
    TextButton(
        onClick = { } ,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = AppTheme.colors.textLinkColor,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        )

    ) {
        Text(
            text = "↑",
            style = AppTheme.typography.titleMain
        )
    }
}