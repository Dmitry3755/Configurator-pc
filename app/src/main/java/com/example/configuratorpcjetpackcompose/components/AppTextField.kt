package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AppTextField(text: String) {
    val email = remember { mutableStateOf("") }
    Column {

        Text(

            text = text,
            modifier = Modifier.background(color = Color.Transparent),
            style = AppTheme.typography.text,
            color = AppTheme.colors.textMainColor

        )
        TextField(
            value = email.value,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.authentication_sign_up_edit_text_hint_email)
                )
            },
            onValueChange = { newText -> email.value = newText },
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = AppTheme.colors.textMainColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = AppTheme.colors.backgroundTextFieldColor
            )
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        AppTextField(stringResource(id = R.string.authentication_sign_up_text_view_your_email))
    }
}