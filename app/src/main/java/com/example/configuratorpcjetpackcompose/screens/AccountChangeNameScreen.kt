package com.example.configuratorpcjetpackcompose.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.ChangePasswordForm
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.example.configuratorpcjetpackcompose.viewmodel.ChangePasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun AccountChangeNameScreen() {

    val viewModel: ChangePasswordViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val changePasswordResultViewError = remember { mutableStateOf(ViewError()) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.2f)
                .padding(start = 30.dp, bottom = 10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.settings_button_change_password))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.8f)
                .background(
                    AppTheme.colors.backgroundFormColor,
                    shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(
                        top = AppTheme.dimensions.textViewPadding,
                        start = AppTheme.dimensions.textViewPadding,
                        end = AppTheme.dimensions.textViewPadding
                    ),
                contentAlignment = Alignment.Center
            ) {
                ChangePasswordForm(
                    newPassword = viewModel.newPassword,
                    oldPassword = viewModel.oldPassword,
                    repeatedPassword = viewModel.repeatedPassword,
                    changePasswordResultViewError = changePasswordResultViewError

                )
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(
                horizontal = AppTheme.dimensions.buttonPadding,
                vertical = AppTheme.dimensions.configurationElementsPadding
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        MainButton(
            textButton = stringResource(id = R.string.btn_text_accept_changes),
            onClick = {
                coroutineScope.launch {
                    viewModel.changePassword(changePasswordResultViewError)
                    if(!changePasswordResultViewError.value.isError.value){
                        Toast.makeText(context,"Пароль успешно изменен", Toast.LENGTH_LONG).show()
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        AccountChangeNameScreen()
    }
}