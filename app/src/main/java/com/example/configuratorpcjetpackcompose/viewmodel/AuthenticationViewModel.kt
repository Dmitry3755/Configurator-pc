package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.firebase.auth.FirebaseUser

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    private var configuratorRepository: ConfiguratorRepository = ConfiguratorRepository()

    var currentFirebaseUser: FirebaseUser? = null

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    suspend fun createUser(resultViewError: MutableState<ViewError>) {
        resultViewError.value = ValidationService.isUserCredentialsValid(
            email = email.value,
            password = password.value,
            repeatedPassword = repeatedPassword.value,
           // application = getApplication<Application>()
        )
        if (!resultViewError.value.isError.value) {
            resultViewError.value = configuratorRepository.createUser(email.value, password.value)
            if (!resultViewError.value.isError.value) {
                currentFirebaseUser = configuratorRepository.getCurrentUser()
            }
        }
    }

    suspend fun loginUser(resultViewError: MutableState<ViewError>) {
        resultViewError.value = ValidationService.isUserCredentialsValid(
            email = email.value,
            password = password.value,
            repeatedPassword = password.value,
           // application = getApplication<Application>()
        )
        if (!resultViewError.value.isError.value
        ) {
            resultViewError.value = configuratorRepository.loginUser(email.value, password.value, application = getApplication())
            if (!resultViewError.value.isError.value) {
                currentFirebaseUser = configuratorRepository.getCurrentUser()
            }
        }
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return configuratorRepository.getCurrentUser()
    }

}