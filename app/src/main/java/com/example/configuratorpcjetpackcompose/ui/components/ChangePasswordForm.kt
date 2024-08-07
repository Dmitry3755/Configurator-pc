package com.example.configuratorpcjetpackcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.utils.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.TagsForTest
import com.example.configuratorpcjetpackcompose.utils.ViewError

@Composable
fun ChangePasswordForm(
    newPassword: MutableState<String>,
    oldPassword: MutableState<String>,
    repeatedPassword: MutableState<String> = remember { mutableStateOf("") },
    changePasswordResultViewError: MutableState<ViewError> = remember { mutableStateOf(ViewError()) }
) {

    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
            .fillMaxSize(1f)
    ) {
        AppTextField(
            textTitle = stringResource(
                id = R.string.settings_text_view_old_password
            ),
            hintTextField = stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_enter_password
            ),
            textInputType = TextInputTypeEnum.Password,
            value = oldPassword,
            viewError = changePasswordResultViewError,
            tagForTest = TagsForTest.OLD_PASSWORD
        )
        Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        AppTextField(
            textTitle = stringResource(
                id = R.string.settings_text_view_new_password
            ),
            hintTextField = stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_enter_password
            ),
            textInputType = TextInputTypeEnum.Password,
            value = newPassword,
            viewError = changePasswordResultViewError,
            tagForTest = TagsForTest.NEW_PASSWORD
        )
        Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        AppTextField(
            textTitle = stringResource(
                id = R.string.settings_text_view_confirm_new_password
            ),
            hintTextField = stringResource(
                id = R.string.authentication_sign_up_edit_text_hint_enter_password
            ),
            textInputType = TextInputTypeEnum.Password,
            value = repeatedPassword,
            viewError = changePasswordResultViewError,
            tagForTest = TagsForTest.REPEATED_NEW_PASSWORD
        )

        if (changePasswordResultViewError.value.isError.value) {
            Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
            Text(
                text = changePasswordResultViewError.value.errorMessage.value,
                color = AppTheme.colors.errorTextColor
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        ChangePasswordForm(remember { mutableStateOf("") },
            remember { mutableStateOf("") },
            remember { mutableStateOf("") })
    }
}