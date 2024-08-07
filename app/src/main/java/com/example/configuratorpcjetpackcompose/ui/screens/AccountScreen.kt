package com.example.configuratorpcjetpackcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.AccountImageAddButton
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.components.UserNameTextField
import com.example.configuratorpcjetpackcompose.ui.navigation.AccountSettingsNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.UserViewModel
import kotlinx.coroutines.launch


@Composable
fun AccountScreen(navController: NavController) {

    val viewModel: UserViewModel = viewModel()
    var avatarSize = LocalConfiguration.current.screenWidthDp * 0.5
    var name = remember { mutableStateOf("")}
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(coroutineScope) {
        coroutineScope.launch() {
            name.value = viewModel.getUserName()
        }
    }

    Column(
        modifier = Modifier
            .background(color = AppTheme.colors.backgroundMainScreenColor)
            .fillMaxSize(1f)
            .padding(
                start =
                AppTheme.dimensions.textViewPadding,
                bottom = 10.dp,
                end = AppTheme.dimensions.textViewPadding
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.15f),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.navigation_bar_text_view_account))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(IntrinsicSize.Min),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box (
                    contentAlignment = Alignment.BottomEnd
                        ) {
                    Image(
                        modifier = Modifier
                            .size(avatarSize.dp)
                            .clip(CircleShape),
                        bitmap = ImageBitmap.imageResource(R.drawable.account_defolt_image),
                        contentDescription = "Empty avatar",
                        contentScale = ContentScale.Fit,
                        filterQuality = FilterQuality.High
                    )
                    AccountImageAddButton()
                }
                UserNameTextField(
                    text = name
                )
            }
        }
        Spacer(Modifier.padding(top = AppTheme.dimensions.verticalElementsPadding))
        MainButton(
            stringResource(id = R.string.settings_button_change_password),
            onClick = {
                navController.navigate(AccountSettingsNavigation.SettingsChangePasswordScreen.route)
            },
            isDelete = false
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(IntrinsicSize.Min),
            contentAlignment = Alignment.Center
        ) {
            MainButton(
                stringResource(id = R.string.account_text_view_exit_from_account),
                onClick = {},
                isDelete = true
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        AccountScreen(navController)
    }
}