package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.Error

@Composable
fun AuthorizationForm(
    isRegistration: Boolean,
    email: MutableState<String>,
    password: MutableState<String>,
    repeatedPassword: MutableState<String> = remember { mutableStateOf("") },
    authResultError: MutableState<Error> = remember { mutableStateOf(Error()) }
) {
    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
            .fillMaxSize(1f)
    ) {
        AppTextField(
            textTitle = stringResource(
                id = R.string.authentication_sign_up_text_view_your_email
            ),
            hintTextField = stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_email
            ),
            textInputType = TextInputTypeEnum.Email,
            value = email,
            error = authResultError
        )
        Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        AppTextField(
            textTitle = stringResource(
                id = R.string.authentication_sign_up_text_view_password
            ),
            hintTextField = stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_enter_password
            ),
            textInputType = TextInputTypeEnum.Password,
            value = password,
            error = authResultError
        )
        if (isRegistration) {
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            AppTextField(
                textTitle = stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_repeat_password
                ),
                hintTextField = stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_enter_password
                ),
                textInputType = TextInputTypeEnum.Password,
                value = repeatedPassword,
                error = authResultError
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        Column(
            modifier = Modifier.fillMaxHeight(1f)
        ) {
            AuthorizationForm(
                true,
                remember { mutableStateOf("") },
                remember { mutableStateOf("") },
                remember { mutableStateOf("") })
        }
    }
}