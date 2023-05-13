package com.example.configuratorpcjetpackcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel

@Composable
fun AccessoryAddedOnConfiguration(
    text: String,
    accessory: Accessory,
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