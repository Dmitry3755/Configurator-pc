package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AuthorizationForm(isRegistration: Boolean) {
    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
            .fillMaxSize(1f)
    ) {
        AppTextField(
            stringResource(
                id = R.string.authentication_sign_up_text_view_your_email
            ), stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_email
            ), TextInputTypeEnum.Email
        )
        Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        AppTextField(
            stringResource(
                id = R.string.authentication_sign_up_text_view_password
            ), stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_enter_password
            ), TextInputTypeEnum.Password
        )
        if(isRegistration) {
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            AppTextField(
                stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_repeat_password
                ), stringResource(
                    id = R.string.authentication_sign_up_edit_text_hint_enter_password
                ), TextInputTypeEnum.Password
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
            AuthorizationForm(true)
        }
    }
}