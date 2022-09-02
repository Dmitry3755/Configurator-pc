package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun HeadersTextView (text: String) {
    Text (
        text = text,
        modifier = Modifier.background(color = Color.Transparent),
        style = AppTheme.typography.title,
        color = AppTheme.colors.textMainColor
    )
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme{
        HeadersTextView(stringResource(id = R.string.authentication_log_in_text_view_log_in))
    }
}
