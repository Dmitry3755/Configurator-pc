package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions (
    val buttonPadding: Dp = 30.dp,
    val textViewPadding: Dp = 30.dp
)
internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }