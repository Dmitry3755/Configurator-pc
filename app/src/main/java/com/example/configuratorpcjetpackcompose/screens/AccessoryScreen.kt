package com.example.configuratorpcjetpackcompose.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.components.AccessoryElement
import com.example.configuratorpcjetpackcompose.components.HeadersTextView
import com.example.configuratorpcjetpackcompose.components.InformationAboutAccessory
import com.example.configuratorpcjetpackcompose.components.MainButton
import com.example.configuratorpcjetpackcompose.components.NetworkImage
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AccessoryScreen(
    idAccessory: String,
    lineType: ConfigurationElementEnum,
    simpleName: String,
    navController: NavController
) {

    val coroutineScope = rememberCoroutineScope()
    val accessoryViewModel: AccessoryViewModel = viewModel()
    var accessory: MutableState<Accessory> = remember {
        mutableStateOf(Accessory(_categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR))
    }
    val accessoryNavController = rememberNavController()

    SideEffect {
        coroutineScope.launch {
            for (accessoriesTypes in lineType.classAccessoriesTypesList) {
                if (simpleName == accessoriesTypes.simpleName) {
                    accessory.value = accessoryViewModel.getAccessory(
                        idAccessory = idAccessory,
                        classAccessoryType = accessoriesTypes
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.backgroundMainScreenColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.35f)
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding,
                    top = 10.dp,
                ),
        ) {
            AccessoryElement(
                accessory = accessory.value,
                navController = accessoryNavController,
                lineType = lineType,
                isFullInformationAboutAccessory = true,
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding
                )
                .fillMaxWidth(1f)
                .weight(0.55f),
        ) {
            InformationAboutAccessory(accessory.value)
        }
        Box(
            modifier = Modifier
                .padding(
                    start =
                    AppTheme.dimensions.textViewPadding,
                    bottom = 10.dp,
                    end = AppTheme.dimensions.textViewPadding
                )
                .fillMaxWidth(1f)
                .weight(0.1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            MainButton(
                textButton = stringResource(id = R.string.btn_text_add),
                onClick = {
                    accessoryViewModel.addAccessoryInConfiguration(accessory.value)
                    // navController.navigateUp()
                    navController.navigate(AccessoryNavigation.AddUpdateConfigurationScreen.route)
                },
                isDelete = false
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AccessoryScreenPreviewIsLight() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        AccessoryScreen(
            idAccessory = "B2kRyh5s5CLFVv53O717",
            lineType = ConfigurationElementEnum.Processor,
            simpleName = "",
            navController = accessoryNavController,
        )
    }
}