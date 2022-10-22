package com.example.configuratorpcjetpackcompose.components

import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AppTextField(
    textTitle: String,
    hintTextField: String,
    textInputType: TextInputTypeEnum,
    value: MutableState<String>
) {
    val showPassword = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
    ) {
        Text(
            text = textTitle,
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxWidth(1f),
            style = AppTheme.typography.text,
            color = AppTheme.colors.textMainColor

        )
        TextField(
            value = value.value,
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth(1f),
            placeholder = {
                Text(
                    text = hintTextField,
                    color = AppTheme.colors.textMainColor
                )
            },
            singleLine = true,
            onValueChange = { newText -> value.value = newText },
            keyboardOptions = when (textInputType) {
                TextInputTypeEnum.Email ->
                    KeyboardOptions(keyboardType = KeyboardType.Email)
                TextInputTypeEnum.Password ->
                    KeyboardOptions(keyboardType = KeyboardType.Password)
                else -> {
                    KeyboardOptions(keyboardType = KeyboardType.Text)
                }
            },
            visualTransformation = if (textInputType == TextInputTypeEnum.Password) {
                if (showPassword.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                if (textInputType == TextInputTypeEnum.Password) {
                    IconButton(onClick = { showPassword.value = !showPassword.value }) {
                        if (showPassword.value) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "Visibility",
                                tint = AppTheme.colors.textMainColor
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = "VisibilityOff",
                                tint = AppTheme.colors.textMainColor
                            )
                        }
                    }
                }
            },
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
        AppTextField(
            stringResource(
                id = R.string.authentication_sign_up_text_view_your_email
            ), stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_email
            ), TextInputTypeEnum.Email,
            remember { mutableStateOf("") }
        )
    }
}