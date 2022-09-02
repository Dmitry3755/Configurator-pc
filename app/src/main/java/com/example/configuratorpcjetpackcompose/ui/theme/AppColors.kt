package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    backgroundMainScreenColor: Color,
    textMainColor: Color,
    backgroundFormColor: Color,
    backgroundButtonColor: Color,
    backgroundTextFieldColor: Color,
    textLinkColor: Color,
    backgroundDeleteButtonColor: Color,
    textDeleteButtonColor: Color,
    selectionColor: Color,
    buttonPressedColor: Color,
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
        buttonPressedColor: Color = this.buttonPressedColor,
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
    }
}

fun lightColors(
    backgroundMainScreenColor: Color = LightShadeOfPurpleBlue,
    textMainColor: Color = DarkShadeOfPurpleBlue,
    backgroundFormColor: Color = LightShadeOfBlue,
    backgroundButtonColor: Color = MediumLightShadeOfPurpleBlue,
    backgroundTextFieldColor: Color = VeryLightShadeOfBlue,
    textLinkColor: Color = MediumLightShadeOfBlue,
    backgroundDeleteButtonColor: Color = Red,
    textDeleteButtonColor: Color = White,
    selectionColor: Color = Cyan,
    buttonPressedColor: Color = PurpleBlue
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
    isLight = true
)

fun darkColors(
    backgroundMainScreenColor: Color = VeryDarkShadeOfPurplishBlue,
    textMainColor: Color = White,
    backgroundFormColor: Color = DarkShadeOfBlue,
    backgroundButtonColor: Color = MediumShadeOfPurpleBlue,
    backgroundTextFieldColor: Color = MediumDarkShadeOfBlue,
    textLinkColor: Color = MediumLightShadeOfBlue,
    backgroundDeleteButtonColor: Color = Red,
    textDeleteButtonColor: Color = White,
    selectionColor: Color = Cyan,
    buttonPressedColor: Color = ShadePurpleBlue
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
    isLight = false
)
val LocalColors = staticCompositionLocalOf { lightColors() }