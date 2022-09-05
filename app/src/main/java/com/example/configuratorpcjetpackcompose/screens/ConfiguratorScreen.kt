package com.example.configuratorpcjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun ConfiguratorScreen() {
    val viewModel: AppViewModel = viewModel()

    /*Column(
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
            HeadersTextView(text = stringResource(id = R.string.configurator_text_view_title_configurator))
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .weight(10f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                color = AppTheme.colors.textMainColor,
                style = AppTheme.typography.text,
                text = stringResource(id = R.string.configurator_text_view_have_not_configurations)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(5f),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                MainButton(
                    stringResource(id = R.string.configurator_text_view_smart_advisor)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                MainButton(
                    stringResource(id = R.string.configurator_text_view_create_configuration)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {

            }
        }
    }*/
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        ConfiguratorScreen()
    }
}