package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppColors
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun MainButtonSmall(textButton: String, onClick: () -> Unit = {}, isDelete: Boolean = false) { //TODO: Слить с обычной кнопкой
    val intSource = remember { MutableInteractionSource() }
    val colorPressed = intSource.collectIsPressedAsState()

    val colorButton: Color
    val colorText: Color

    if (isDelete) {
        colorButton =
            if (colorPressed.value) AppTheme.colors.backgroundPressDeleteButtonColor else AppTheme.colors.backgroundDeleteButtonColor
        colorText =
            if (colorPressed.value) AppTheme.colors.textDeleteButtonColor else AppTheme.colors.textDeleteButtonColor
    } else {
        colorButton =
            if (colorPressed.value) AppTheme.colors.buttonPressedColor else AppTheme.colors.backgroundButtonColor
        colorText = AppTheme.colors.textButtonColor
    }

    Button(
        interactionSource = intSource,
        onClick = onClick,
        shape = RoundedCornerShape(20.dp), //TODO: Перенести значение в AppDimensions
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorButton,
            contentColor = AppTheme.colors.textMainColor
        )
    ) {
        Text(
            text = textButton,
            color = colorText,
            modifier = Modifier.padding(
                vertical = 5.dp
            ),
            style = AppTheme.typography.buttonText
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(AppTheme.colors.backgroundDeleteButtonColor)
        ) {
            MainButtonSmall(
                textButton = stringResource(id = R.string.authentication_log_in_text_view_log_in),
                onClick = {},
                isDelete = false
            )
        }

    }
}