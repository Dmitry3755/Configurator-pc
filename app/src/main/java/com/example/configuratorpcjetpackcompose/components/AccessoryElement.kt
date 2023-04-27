package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.navigation.AccessoryNavigation
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AccessoryElement(
    accessory: Accessory,
    navController: NavController,
    lineType: ConfigurationElementEnum,
    isFullInformationAboutAccessory: Boolean
) {

    val coroutineScope = rememberCoroutineScope()
    val viewModel: AccessoryViewModel = viewModel()
    val accessoryUri = remember { mutableStateOf(Uri.EMPTY) }
    var imageSize : Double = if (!isFullInformationAboutAccessory) {
        LocalConfiguration.current.screenWidthDp * 0.4
    }
    else{
        LocalConfiguration.current.screenHeightDp * 1.0
    }

    SideEffect {
        coroutineScope.launch {
            if (accessory.uri != "") {
                accessoryUri.value = viewModel.getAccessoriesUri(accessory.uri)
            } else {
                accessoryUri.value = Uri.EMPTY
            }
        }
    }

    Card(
        modifier = Modifier
            .border(
                border = if (!isFullInformationAboutAccessory) {
                    BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor)
                } else {
                    BorderStroke(0.dp, Color.Transparent)
                },
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth(),
        onClick = {
            if (!isFullInformationAboutAccessory) {
                navController.navigate(AccessoryNavigation.AccessoryScreen.route + "/${lineType.name}" + "/${accessory.javaClass.simpleName}" + "/${accessory._idAccessory}")
            }
        },
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            NetworkImage(accessoryUri, imageSize)
            if (!isFullInformationAboutAccessory) {
                Text(
                    text = accessory.name,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = AppTheme.dimensions.configurationElementsPadding),
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.text,
                    softWrap = false
                )
                Text(
                    text = accessory._priceAccessory.toString() + " ₽",
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = AppTheme.dimensions.configurationElementsPadding),
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.text
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun AccessoryElementPreviewLight() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        AccessoryElement(
            Accessory(
                _nameAccessory = "i7",
                _priceAccessory = 1923.0,
                _descriptionAccessory = "12dsfert",
                _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                _uriAccessory = ""
            ),
            navController = accessoryNavController,
            lineType = ConfigurationElementEnum.Processor,
            isFullInformationAboutAccessory = false
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AccessoryElementPreviewDark() {
    AppTheme() {
        val accessoryNavController = rememberNavController()
        AccessoryElement(
            Accessory(
                _nameAccessory = "i7",
                _priceAccessory = 1923.0,
                _descriptionAccessory = "12dsfert",
                _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                _uriAccessory = ""
            ),
            navController = accessoryNavController,
            lineType = ConfigurationElementEnum.Processor,
            isFullInformationAboutAccessory = true
        )
    }
}