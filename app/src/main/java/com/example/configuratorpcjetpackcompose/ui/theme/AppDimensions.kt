package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.components.ConfigurationElement

data class AppDimensions (
    val buttonPadding: Dp = 30.dp,
    val textViewPadding: Dp = 30.dp,
    val verticalElementsPadding: Dp = 10.dp,
    val configurationElementsPadding: Dp = 5.dp,
    val configurationElementsRoundedCornerShape: Dp = 30.dp,
    val iconToggleButtonSize: Dp = 25.dp
)
internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }