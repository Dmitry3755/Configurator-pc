package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.services.AuthenticationService
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.Error
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers.IO

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private var configuratorRepository: ConfiguratorRepository = ConfiguratorRepository()

    var currentFirebaseUser: FirebaseUser? = null

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    suspend fun createUser(resultError: MutableState<Error>) {
        resultError.value = ValidationService.isUserCredentialsValid(
            email = email.value,
            password = password.value,
            repeatedPassword = repeatedPassword.value,
            application = getApplication<Application>()
        )
        if (!resultError.value.isError.value) {
            resultError.value = configuratorRepository.createUser(email.value, password.value)
            if (!resultError.value.isError.value) {
                currentFirebaseUser = configuratorRepository.getCurrentUser()
            }
        }
    }

    suspend fun loginUser(resultError: MutableState<Error>) {
        resultError.value = ValidationService.isUserCredentialsValid(
            email = email.value,
            password = password.value,
            repeatedPassword = password.value,
            application = getApplication<Application>()
        )
        if (!resultError.value.isError.value
        ) {
            resultError.value = configuratorRepository.loginUser(email.value, password.value)
            if (!resultError.value.isError.value) {
                currentFirebaseUser = configuratorRepository.getCurrentUser()
            }
        }
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return configuratorRepository.getCurrentUser()
    }

}