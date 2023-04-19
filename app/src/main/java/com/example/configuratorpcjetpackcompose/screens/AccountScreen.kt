package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
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
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.AccountImageAddButton
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme


@Composable
fun AccountScreen() {

    var avatarSize = LocalConfiguration.current.screenWidthDp * 0.5

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
                HeadersTextView(text = stringResource(id = R.string.account_text_view_name))
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .weight(0.65f))
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
        AccountScreen()
    }
}