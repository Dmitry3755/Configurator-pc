package com.example.configuratorpcjetpackcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun AccessoryAddedOnConfiguration(
    text: String,
    accessory: com.example.data.entities.AccessoryApiResponse,
    viewModel: AccessoriesViewModel = viewModel(),
    isDeleted: MutableState<Boolean>
) {
    Row(
        modifier = Modifier
            .padding(
                top = AppTheme.dimensions.verticalElementsPadding,
                bottom = AppTheme.dimensions.verticalElementsPadding
            )
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(0.7f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = AppTheme.colors.textMainColor,
                style = AppTheme.typography.text
            )
        }
        MainButton(
            textButton = stringResource(id = R.string.btn_text_delete),
            onClick = {
                viewModel.removeAccessoryInConfiguration(
                    accessory
                )
                isDeleted.value = !isDeleted.value
            },
            isDelete = true,
            isSmall = true
        )
    }
}