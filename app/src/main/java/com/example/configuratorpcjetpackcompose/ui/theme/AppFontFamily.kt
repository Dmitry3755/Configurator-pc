package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.configuratorpcjetpackcompose.R
import androidx.compose.ui.text.font.FontStyle

data class AppFontFamily (
    val PoppinsBold: FontStyle =  FontStyle(R.font.poppins_bold),
    val PoppinsMedium: FontStyle = FontStyle(R.font.poppins_medium),
)

internal val LocalFontFamily = staticCompositionLocalOf { AppFontFamily() }