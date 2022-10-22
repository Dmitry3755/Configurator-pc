package com.example.configuratorpcjetpackcompose.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.services.ValidationService

class AppViewModel : ViewModel() {

    private var configuratorRepository: ConfiguratorRepository = ConfiguratorRepository()

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    fun createUser() {
        if (ValidationService.isUserCredentialsValid(
                email = email.value,
                password = password.value,
                repeatedPassword = repeatedPassword.value
            )
        ) {
            configuratorRepository.createUser(email.value, password.value)
        }
    }
}