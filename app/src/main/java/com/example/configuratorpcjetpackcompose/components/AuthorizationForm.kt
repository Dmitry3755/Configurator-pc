package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.utils.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.TagsForTest
import com.example.configuratorpcjetpackcompose.utils.ViewError

@Composable
fun AuthorizationForm(
    isRegistration: Boolean,
    email: MutableState<String>,
    password: MutableState<String>,
    repeatedPassword: MutableState<String> = remember { mutableStateOf("") },
    authResultViewError: MutableState<ViewError> = remember { mutableStateOf(ViewError()) }
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
            viewError = authResultViewError,
            tagForTest = TagsForTest.EMAIL
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
            viewError = authResultViewError,
            tagForTest = TagsForTest.PASSWORD
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
                viewError = authResultViewError,
                tagForTest = TagsForTest.REPEATED_PASSWORD
            )
        }
        if(authResultViewError.value.isError.value) {
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            Text(
                modifier = Modifier.testTag(TagsForTest.RESULT),
                text = authResultViewError.value.errorMessage.value,
                color = AppTheme.colors.errorTextColor
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