package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.UserViewModel

@Composable
fun FavoriteScreen() {
    val viewModel: UserViewModel = viewModel()
    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colors.backgroundMainScreenColor
            )
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    start = 30.dp
                )
                .weight(2f),
            contentAlignment = Alignment.BottomEnd
        ) {
            HeadersTextView(text = stringResource(id = R.string.navigation_bar_text_view_favorite))
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        FavoriteScreen()
    }
}