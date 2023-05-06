package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.AuthorizationForm
import com.example.configuratorpcjetpackcompose.components.AuthorizationHeadersTextView
import com.example.configuratorpcjetpackcompose.components.LogInOrSingUp
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.navigation.Navigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.example.configuratorpcjetpackcompose.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun SingUpScreen(navController: NavController) {
    val viewModel: UserViewModel = viewModel()

    val coroutineScope = rememberCoroutineScope()

    val signUpResultViewError = remember { mutableStateOf(ViewError()) }

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
            AuthorizationHeadersTextView(text = stringResource(id = R.string.authentication_sign_up_text_view_create))
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
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .padding(
                        top = AppTheme.dimensions.textViewPadding,
                        start = AppTheme.dimensions.textViewPadding,
                        end = AppTheme.dimensions.textViewPadding
                    ),
                contentAlignment = Alignment.Center
            ) {
                AuthorizationForm(
                    isRegistration = true,
                    email = viewModel.email,
                    password = viewModel.password,
                    repeatedPassword = viewModel.repeatedPassword,
                    authResultViewError = signUpResultViewError
                )
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = AppTheme.dimensions.buttonPadding
            )
        ) {
            MainButton(
                stringResource(id = R.string.authentication_sign_up_button_text_create_account),
                onClick = {
                    coroutineScope.launch {
                        viewModel.createUser(signUpResultViewError)
                        if (viewModel.currentFirebaseUser != null) {
                            navController.navigate(Navigation.MainNavigationScreen.route)
                        }
                    }

                },
                isDelete = false
            )
            LogInOrSingUp(
                text = stringResource(id = R.string.authentication_sign_up_text_view_already_have_an_account),
                textButton = stringResource(id = R.string.authentication_sign_up_button_text_log_in),
                onClick = {
                    navController.navigate(Navigation.LogInScreen.route)
                }
            )
        }
    }
}


@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        SingUpScreen(navController)
    }
}