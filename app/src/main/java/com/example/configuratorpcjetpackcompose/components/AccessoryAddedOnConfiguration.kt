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
import androidx.compose.runtime.Composable
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
    configuration: com.example.configuratorpcjetpackcompose.model.data_class.Configuration,
    accessory: Class<out Accessory>,
    viewModel: AccessoriesViewModel = viewModel(),
    navController: NavController,
    configurationElement: ConfigurationElementEnum
) {
    Row(
        modifier = Modifier
            .padding(top = AppTheme.dimensions.verticalElementsPadding)
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
                    configuration.getAccessoryFromConfiguration(
                        accessory
                    )
                )
            },
            isDelete = true,
            isSmall = true
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier.fillMaxWidth(0.8f)) {
        MainButton(
            textButton = stringResource(id = R.string.btn_text_add),
            onClick = {
                navController.navigate(AccessoryNavigation.AllSelectedComponentsScreen.route + "/${configurationElement.name}")
            }
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}