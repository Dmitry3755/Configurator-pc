package com.example.configuratorpcjetpackcompose.components

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.utils.ThemeTypeEnum
import com.example.configuratorpcjetpackcompose.ui.theme.*
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

@Composable
fun ThemeElement(isTheme: ThemeTypeEnum, selectedTheme: MutableState<ThemeTypeEnum>) {

    var darkTheme: Boolean = isSystemInDarkTheme()
    val context = LocalContext.current
    val text = stringResource(id = R.string.text)
    var viewModel: AppViewModel = viewModel()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(5.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                selectedTheme.value = isTheme
               viewModel.darkTheme.value = when (isTheme) {
                    ThemeTypeEnum.Light -> false
                    ThemeTypeEnum.Dark -> true
                    ThemeTypeEnum.System -> darkTheme
                }

/*                viewModel.onThemeChanged(
                    when (isTheme) {
                        ThemeTypeEnum.Light -> false
                        ThemeTypeEnum.Dark -> true
                        ThemeTypeEnum.System -> darkTheme
                    }
                )*/
            },
    ) {
        Text(
            text = stringResource(
                when (isTheme) {
                    ThemeTypeEnum.Light -> R.string.settings_theme_change_light
                    ThemeTypeEnum.Dark -> R.string.settings_theme_change_dark
                    else -> R.string.settings_theme_change_system
                }
            ),
            style = AppTheme.typography.buttonText,
            color = AppTheme.colors.textMainColor,
        )

        Box(
            modifier = Modifier
                .weight(1f, fill = true)
                .fillMaxWidth(1f)
                .background(
                    color = when (isTheme) {
                        ThemeTypeEnum.Light -> com.example.configuratorpcjetpackcompose.ui.theme.White
                        ThemeTypeEnum.Dark -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                        else -> com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                    },
                    shape = RoundedCornerShape(corner = CornerSize(30.dp))
                )
                .border(
                    shape = RoundedCornerShape(corner = CornerSize(30.dp)),
                    border = BorderStroke(2.dp, AppTheme.colors.backgroundButtonColor),
                )
                .drawBehind {
                    if (isTheme == ThemeTypeEnum.System) {

                        clipPath(
                            path = Path().apply {
                                addRoundRect(
                                    roundRect = RoundRect(
                                        left = 0.dp.toPx(),
                                        top = 0.dp.toPx(),
                                        right = size.width,
                                        bottom = size.height,
                                        cornerRadius = CornerRadius(
                                            x = 30.dp.toPx(),
                                            y = 30.dp.toPx()
                                        )
                                    )
                                )
                            },
                            clipOp = ClipOp.Intersect,
                            block = {
                                drawPath(
                                    path = Path().apply {
                                        moveTo(0.dp.toPx(), size.height)
                                        lineTo(size.width, 0.dp.toPx())
                                        lineTo(0.dp.toPx(), 0.dp.toPx())
                                        close()
                                    },
                                    color = com.example.configuratorpcjetpackcompose.ui.theme.White
                                )
                                drawPath(
                                    path = Path().apply {
                                        moveTo(0.dp.toPx(), size.height)
                                        lineTo(size.width, 0.dp.toPx())
                                        lineTo(size.width, size.height)
                                        close()
                                    },
                                    color = com.example.configuratorpcjetpackcompose.ui.theme.VeryDarkShadeOfPurplishBlue
                                )
                                drawLine(
                                    color = when (darkTheme) {
                                        true -> com.example.configuratorpcjetpackcompose.ui.theme.ShadeOfBlueBlue
                                        false -> com.example.configuratorpcjetpackcompose.ui.theme.MediumLightShadeOfBlue
                                    },
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = 2.dp.toPx()
                                )
                                drawIntoCanvas {
                                    val paint = Paint()
                                        .asFrameworkPaint()
                                        .apply {
                                            isAntiAlias = true
                                            textSize = 18.sp.toPx()
                                            color =
                                                com.example.configuratorpcjetpackcompose.ui.theme.White.toArgb()
                                            typeface = ResourcesCompat.getFont(
                                                context,
                                                R.font.poppins_bold
                                            )
                                        }

                                    it.nativeCanvas.drawText(  //TODO: выравнить текст
                                        text,
                                        center.x + size.width / 4 - text.length * paint.textSize / 2,
                                        center.y + size.height / 4,
                                        paint
                                    )
                                }
                                drawIntoCanvas {

                                    val paint = Paint()
                                        .asFrameworkPaint()
                                        .apply {
                                            isAntiAlias = true
                                            textSize = 18.sp.toPx()
                                            color =
                                                com.example.configuratorpcjetpackcompose.ui.theme.Black.toArgb()
                                            typeface = ResourcesCompat.getFont(
                                                context,
                                                R.font.poppins_bold
                                            )
                                        }
                                    it.nativeCanvas.drawText(   //TODO: выравнить текст
                                        text,
                                        center.x - size.width / 4,
                                        center.y - size.height / 4,
                                        paint
                                    )
                                }
                            }
                        )
                    }
                }
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isTheme != ThemeTypeEnum.System) {
                Text(
                    text = stringResource(id = R.string.text),
                    style = AppTheme.typography.buttonText,
                    color = when (isTheme) {
                        ThemeTypeEnum.Light -> com.example.configuratorpcjetpackcompose.ui.theme.Black
                        ThemeTypeEnum.Dark -> com.example.configuratorpcjetpackcompose.ui.theme.White
                        else -> com.example.configuratorpcjetpackcompose.ui.theme.White
                    }
                )
            }
        }
        Icon(
            modifier = Modifier.size(25.dp),
            painter = painterResource(
                if (selectedTheme.value == isTheme)
                    R.drawable.ic_checkmark
                else
                    R.drawable.ic_circle_outline
            ),
            contentDescription = null,
            tint = AppTheme.colors.backgroundButtonColor
        )
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun DefaultPreviewLight() {
    AppTheme() {
        val viewModel: AppViewModel = viewModel()
        Box(
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth(0.45f)
            ) {
                ThemeElement(ThemeTypeEnum.Light, viewModel.selectedTheme)
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DefaultPreviewDark() {
    AppTheme() {
        val viewModel: AppViewModel = viewModel()
        ThemeElement(ThemeTypeEnum.System, viewModel.selectedTheme)
    }
}