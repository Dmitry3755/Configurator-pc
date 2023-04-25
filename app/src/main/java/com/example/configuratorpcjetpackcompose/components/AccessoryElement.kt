package com.example.configuratorpcjetpackcompose.components

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.CategoryAccessoryEnum
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

@Composable
fun AccessoryElement(accessory: Accessory) {

    val coroutineScope = rememberCoroutineScope()
    val viewModel: AccessoryViewModel = viewModel()
    val accessoryUri = remember { mutableStateOf(Uri.EMPTY) }

    SideEffect {
        coroutineScope.launch {
            if(accessory.uri != "") {
                accessoryUri.value = viewModel.getAccessoriesUri(accessory.uri)
            }
        }
    }

    Card(
        modifier = Modifier
            .border(
                border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            NetworkImage(accessoryUri)
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
                    .padding(horizontal = AppTheme.dimensions .configurationElementsPadding),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.text
            )
        }
    }
}

@Preview
@Composable
private fun AccessoryElementPreview() {
    AppTheme() {
        AccessoryElement(
            Accessory(
                _nameAccessory = "i7",
                _priceAccessory = 1923.0,
                _descriptionAccessory = "12dsfert",
                _categoryAccessoryEnum = CategoryAccessoryEnum.PROCESSOR,
                _uriAccessory = ""
            )
        )
    }
}