package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError

@Composable
fun ConfigurationAlertDialog(
    saveResultViewError: MutableState<ConfigurationError>
) {
    AlertDialog(
        onDismissRequest = {
            saveResultViewError.value.isError.value = false
        },
        title = {
            Text(
                text = stringResource(id = R.string.error),
                style = AppTheme.typography.errorTitle,
                color = AppTheme.colors.errorTextColor
            )
        },
        text = {
            Text(
                text = saveResultViewError.value.errorMessage.value,
                style = AppTheme.typography.text
            )
        },
        buttons = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = AppTheme.dimensions.verticalElementsPadding,
                        start = AppTheme.dimensions.buttonPadding,
                        end = AppTheme.dimensions.buttonPadding
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainButton(
                    onClick = { saveResultViewError.value.isError.value = false },
                    textButton = "Ок"
                )
            }
        }
    )

}