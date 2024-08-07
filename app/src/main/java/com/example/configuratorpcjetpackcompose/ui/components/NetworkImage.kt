package com.example.configuratorpcjetpackcompose.ui.components

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme


@Composable
fun NetworkImage(url: MutableState<Uri>, imageSize: Double) {

    SubcomposeAsyncImage(
        modifier = Modifier
            .padding(AppTheme.dimensions.configurationElementsPadding)
            .size(imageSize.dp),
        alignment = Alignment.Center,
        model = url.value,
        contentDescription = null
    ) {
        val state = painter.state
        when (state) {
            is AsyncImagePainter.State.Loading -> CircularProgressIndicator(
                modifier = Modifier
                    .padding(AppTheme.dimensions.verticalElementsPadding),
                color = AppTheme.colors.backgroundButtonColor
            )
            is AsyncImagePainter.State.Error -> SubcomposeAsyncImageContent(
                painter = painterResource(
                    id = R.drawable.placeholder_image
                )
            )
            else -> SubcomposeAsyncImage(model = url.value, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun NetworkImagePreview() {
    AppTheme() {
        val a = remember {
            mutableStateOf(Uri.EMPTY)
        }
        NetworkImage(a, LocalConfiguration.current.screenWidthDp * 0.4)
    }
}