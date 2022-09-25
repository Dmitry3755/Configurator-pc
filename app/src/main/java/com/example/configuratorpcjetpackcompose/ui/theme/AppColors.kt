package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow

class AppColors(
    backgroundMainScreenColor: Color,
    backgroundFormColor: Color,
    backgroundTextFieldColor: Color,

    textMainColor: Color,

    backgroundButtonColor: Color,
    textButtonColor: Color,
    buttonPressedColor: Color,
    textLinkColor: Color,

    backgroundDeleteButtonColor: Color,
    textDeleteButtonColor: Color,
    backgroundPressDeleteButtonColor: Color,

    selectionColor: Color,

    isLight: Boolean
) {
    var backgroundMainScreenColor by mutableStateOf(backgroundMainScreenColor)
        private set
    var textMainColor by mutableStateOf(textMainColor)
        private set
    var backgroundFormColor by mutableStateOf(backgroundFormColor)
        private set
    var backgroundButtonColor by mutableStateOf(backgroundButtonColor)
        private set
    var backgroundTextFieldColor by mutableStateOf(backgroundTextFieldColor)
        private set
    var textLinkColor by mutableStateOf(textLinkColor)
        private set
    var backgroundDeleteButtonColor by mutableStateOf(backgroundDeleteButtonColor)
        private set
    var textDeleteButtonColor by mutableStateOf(textDeleteButtonColor)
        private set
    var selectionColor by mutableStateOf(selectionColor)
        private set
    var buttonPressedColor by mutableStateOf(buttonPressedColor)
        private set
    var backgroundPressDeleteButtonColor by mutableStateOf(backgroundPressDeleteButtonColor)
        private set
    var textButtonColor by mutableStateOf(textButtonColor)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        backgroundMainScreenColor: Color = this.backgroundMainScreenColor,
        textMainColor: Color = this.textMainColor,
        backgroundFormColor: Color = this.backgroundFormColor,
        backgroundButtonColor: Color = this.backgroundButtonColor,
        backgroundTextFieldColor: Color = this.backgroundTextFieldColor,
        textLinkColor: Color = this.textLinkColor,
        backgroundDeleteButtonColor: Color = this.backgroundDeleteButtonColor,
        textDeleteButtonColor: Color = this.textDeleteButtonColor,
        selectionColor: Color = this.selectionColor,
        backgroundPressDeleteButtonColor: Color = this.backgroundPressDeleteButtonColor,
        textButtonColor: Color = this.textButtonColor,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        backgroundMainScreenColor,
        textMainColor,
        backgroundFormColor,
        backgroundButtonColor,
        backgroundTextFieldColor,
        textLinkColor,
        backgroundDeleteButtonColor,
        textDeleteButtonColor,
        selectionColor,
        buttonPressedColor,
        textButtonColor,
        backgroundPressDeleteButtonColor,
        isLight
    )

    // will be explained later
  fun updateColorsFrom(other: AppColors) {
        backgroundMainScreenColor = other.backgroundMainScreenColor
        textMainColor = other.textMainColor
        backgroundFormColor = other.backgroundFormColor
        backgroundButtonColor = other.backgroundButtonColor
        backgroundTextFieldColor = other.backgroundTextFieldColor
        textLinkColor = other.textLinkColor
        backgroundDeleteButtonColor = other.backgroundDeleteButtonColor
        textDeleteButtonColor = other.textDeleteButtonColor
        selectionColor = other.selectionColor
        buttonPressedColor = other.buttonPressedColor
        textButtonColor = other.textButtonColor
        backgroundPressDeleteButtonColor = other.backgroundPressDeleteButtonColor
    }
}

fun lightColors(
    backgroundMainScreenColor: Color = White,
    textMainColor: Color = Black,
    backgroundFormColor: Color = VeryLightShadeOfRed,
    backgroundButtonColor: Color = MediumLightShadeOfBlue,
    backgroundTextFieldColor: Color = White,
    textLinkColor: Color = MediumLightShadeOfBlue,
    backgroundDeleteButtonColor: Color = Red,
    textDeleteButtonColor: Color = White,
    selectionColor: Color = Cyan,
    textButtonColor: Color = White,
    backgroundPressDeleteButtonColor: Color = MediumDarkShadeOfRed,
    buttonPressedColor: Color = MediumDarkShadeOfBlue,

): AppColors = AppColors(
    backgroundMainScreenColor = backgroundMainScreenColor,
    textMainColor = textMainColor,
    backgroundFormColor = backgroundFormColor,
    backgroundButtonColor = backgroundButtonColor,
    backgroundTextFieldColor = backgroundTextFieldColor,
    textLinkColor = textLinkColor,
    backgroundDeleteButtonColor = backgroundDeleteButtonColor,
    textDeleteButtonColor = textDeleteButtonColor,
    selectionColor = selectionColor,
    textButtonColor = textButtonColor,
    buttonPressedColor = buttonPressedColor,
    backgroundPressDeleteButtonColor = backgroundPressDeleteButtonColor,
    isLight = true
)

fun darkColors(
    backgroundMainScreenColor: Color = VeryDarkShadeOfPurplishBlue,
    textMainColor: Color = White,
    backgroundFormColor: Color = DarkShadeOfPurpleBlue,
    backgroundButtonColor: Color = ShadeOfBlueBlue,
    backgroundTextFieldColor: Color = MediumDarkShadeOfPurpleBlue,
    textLinkColor: Color = MediumLightShadeOfBlue,
    backgroundDeleteButtonColor: Color = Red,
    textDeleteButtonColor: Color = White,
    selectionColor: Color = Cyan,
    textButtonColor: Color = White,
    backgroundPressDeleteButtonColor: Color = MediumDarkShadeOfRed,
    buttonPressedColor: Color = MediumDarkShadeOfBlueBlue
): AppColors = AppColors(
    backgroundMainScreenColor = backgroundMainScreenColor,
    textMainColor = textMainColor,
    backgroundFormColor = backgroundFormColor,
    backgroundButtonColor = backgroundButtonColor,
    backgroundTextFieldColor = backgroundTextFieldColor,
    textLinkColor = textLinkColor,
    backgroundDeleteButtonColor = backgroundDeleteButtonColor,
    textDeleteButtonColor = textDeleteButtonColor,
    selectionColor = selectionColor,
    buttonPressedColor = buttonPressedColor,
    textButtonColor = textButtonColor,
    backgroundPressDeleteButtonColor = backgroundPressDeleteButtonColor,
    isLight = false
)
val LocalColors = staticCompositionLocalOf { lightColors() }