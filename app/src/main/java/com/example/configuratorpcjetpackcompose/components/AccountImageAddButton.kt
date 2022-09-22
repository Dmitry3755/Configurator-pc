package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.TextInputTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun AccountImageAddButton() {

    Button(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Min)
            .size(50.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.borderConfigurationColor
        ),
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(2.dp, AppTheme.colors.textDeleteButtonColor),
        onClick = {}
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = null,
            tint = AppTheme.colors.textDeleteButtonColor
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme {
        AccountImageAddButton()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme {
        AccountImageAddButton()
    }
}