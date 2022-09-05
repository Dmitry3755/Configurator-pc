package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun MainButton(textButton: String, onClick: () -> Unit = {}) {
    val intSource = remember { MutableInteractionSource() }
    val colorPressed = intSource.collectIsPressedAsState()
    var colorButton =
        if (colorPressed.value) AppTheme.colors.buttonPressedColor else AppTheme.colors.backgroundButtonColor
    var colorText =
        if (colorPressed.value) AppTheme.colors.textDeleteButtonColor else AppTheme.colors.textMainColor

    Button(
        modifier = Modifier
            .fillMaxWidth(1f),
        interactionSource = intSource,
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
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
        val navController = rememberNavController()
        MainButton(
            stringResource(id = R.string.authentication_log_in_text_view_log_in),
            {}
        )
    }
}