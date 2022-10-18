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
    val roundedCornerShape: Dp = 30.dp

)
internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }