package com.example.configuratorpcjetpackcompose.components

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.squareup.picasso.Picasso


@Composable
fun NetworkImage(url: MutableState<Uri>) {

    var imageSize = LocalConfiguration.current.screenWidthDp * 0.4

    SubcomposeAsyncImage(
        model = url.value,
        contentDescription = null,
        modifier = Modifier
            .padding(AppTheme.dimensions.configurationElementsPadding)
            .size(imageSize.dp),
        alignment = Alignment.Center,
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            SubcomposeAsyncImageContent(painter = painterResource(id = R.drawable.placeholder_image))
        } else {
            SubcomposeAsyncImage(model = url.value, contentDescription = "")
        }
    }
}
