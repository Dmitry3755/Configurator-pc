package com.example.configuratorpcjetpackcompose.screens

import android.widget.ImageView
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.navigation.Navigation

@Composable
fun StartMainScreen(navController: NavController) {

    var isVisible by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = AppTheme.colors.startBackgroundScreen)
            .clickable(onClick = { navController.navigate(Navigation.LogInScreen.route) }),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(state) {
                isVisible = !isVisible
            }
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 3000,
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
                exit = fadeOut(),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = AppTheme.colors.textButtonColor,
                        style = AppTheme.typography.titleMain
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(top = AppTheme.dimensions.verticalElementsPadding)
                    )
                    Icon(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_pc_computer),
                        tint = AppTheme.colors.textButtonColor,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        StartMainScreen(navController)
    }
}