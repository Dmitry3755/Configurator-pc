package com.example.configuratorpcjetpackcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.ui.theme.theme.AppTheme
import com.example.configuratorpcjetpackcompose.viewmodel.UserViewModel
import kotlinx.coroutines.launch


@Composable
fun UserNameTextField(text: MutableState<String>) {

    val viewModel: UserViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val focus = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    TextField(
        value = text.value,
        textStyle = AppTheme.typography.titleMain,
        modifier = Modifier
            .background(color = Color.Transparent)
            .fillMaxWidth(1f)
            .onFocusChanged {
                if (focus.value) {
                    coroutineScope.launch {
                        viewModel.userNameChange(text.value)
                    }
                }
            },
        keyboardActions = KeyboardActions(onDone = {
            focus.value = true
            focusManager.clearFocus()
        }),
        singleLine = true,
        onValueChange = { newText ->
            text.value = newText
        },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = AppTheme.colors.textMainColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = AppTheme.colors.backgroundTextFieldColor
        )
    )

}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        UserNameTextField(text = remember { mutableStateOf("Name") })
    }
}