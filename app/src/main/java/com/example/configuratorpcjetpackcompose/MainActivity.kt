package com.example.configuratorpcjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.navigation.NavGraph
import com.example.configuratorpcjetpackcompose.screens.StartMainScreen
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.ui.theme.darkColors
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appViewModel: AppViewModel = viewModel()
           // val darkTheme : Boolean by appViewModel.theme.observeAsState(initial = true)
            val darkTheme = remember {
                appViewModel.darkTheme
            }
            appViewModel.darkTheme = darkTheme
            AppTheme(darkTheme = appViewModel.darkTheme) {
                NavGraph()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        NavGraph()
    }
}