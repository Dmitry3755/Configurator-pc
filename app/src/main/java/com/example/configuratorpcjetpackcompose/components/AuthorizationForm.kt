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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AuthorizationForm(
    isRegistration: Boolean,
    email: MutableState<String>,
    password: MutableState<String>,
    repeatedPassword: MutableState<String> = remember { mutableStateOf("") }
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
            value = email
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
            value = password
        )
        if (isRegistration) {
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            AppTextField(
                textTitle = stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_repeat_password
                ),
                hintTextField =stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_enter_password
                ),
                textInputType = TextInputTypeEnum.Password,
                value = repeatedPassword
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