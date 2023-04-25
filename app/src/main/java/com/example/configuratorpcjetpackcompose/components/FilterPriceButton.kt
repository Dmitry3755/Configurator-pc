package com.example.configuratorpcjetpackcompose.components

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoryViewModel

@Composable
fun FilterPriceButton() {

    val viewModel: AccessoryViewModel = viewModel()
    val text = remember { mutableStateOf(R.string.btn_text_price_up) }
    val list = viewModel.listAccessory.toList()


    TextButton(
        onClick = {
            if( text.value == R.string.btn_text_price_up){
                viewModel.filterPriceAccessories(list, true)
                text.value = R.string.btn_text_price_down
            }
            else{
                viewModel.filterPriceAccessories(list, false)
                text.value = R.string.btn_text_price_up
            }
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = AppTheme.colors.textMainColor,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        )

    ) {
        Text(
            text =  stringResource(id = R.string.btn_text_price) + stringResource(id = text.value),
            style = AppTheme.typography.buttonText
        )
    }
}
