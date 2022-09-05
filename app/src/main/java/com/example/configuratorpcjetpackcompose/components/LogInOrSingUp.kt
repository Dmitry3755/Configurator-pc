package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun LogInOrSingUp(text: String, textButton: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier.fillMaxWidth(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Text(
            text = text,
            modifier = Modifier
                .background(
                    color = Color.Transparent,
                ),
            style = AppTheme.typography.textSingUpOrLogIn,
            color = AppTheme.colors.textMainColor
        )
        TextButton(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = AppTheme.colors.textLinkColor,
                disabledBackgroundColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            )

        ) {
            Text(
                text = textButton,
                style = AppTheme.typography.buttonAuthenticationText
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController = rememberNavController()
        LogInOrSingUp(
            stringResource(id = R.string.authentication_log_in_text_view_have_not_account),
            stringResource(id = R.string.authentication_sign_up_button_text_log_in),
            {}
        )
    }
}