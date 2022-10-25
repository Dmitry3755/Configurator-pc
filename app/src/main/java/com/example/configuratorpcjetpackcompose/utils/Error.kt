package com.example.configuratorpcjetpackcompose.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Error(
    var isError: MutableState<Boolean> = mutableStateOf(false),
    var errorMessage: MutableState<String> = mutableStateOf("success")
) {}