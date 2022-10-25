package com.example.configuratorpcjetpackcompose.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers.IO

class AppViewModel : ViewModel() {

    private var configuratorRepository: ConfiguratorRepository = ConfiguratorRepository()

    var currentFirebaseUser: FirebaseUser? = null

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    suspend fun createUser() {
        if (ValidationService.isUserCredentialsValid(
                email = email.value,
                password = password.value,
                repeatedPassword = repeatedPassword.value
            )
        ) {
            //viewModelScope.launch(Dispatchers.IO) {  }
            currentFirebaseUser = configuratorRepository.createUser(email.value, password.value)
        }
    }

    suspend fun loginUser() {
        if (ValidationService.isUserCredentialsValid(
                email = email.value,
                password = password.value,
                repeatedPassword = password.value
            )
        ) {
            currentFirebaseUser = configuratorRepository.loginUser(email.value, password.value)
        }
    }

}