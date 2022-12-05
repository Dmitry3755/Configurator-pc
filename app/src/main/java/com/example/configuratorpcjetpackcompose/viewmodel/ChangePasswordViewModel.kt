package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.services.AuthenticationService.passwordUpdateUser
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.firebase.auth.FirebaseUser

class ChangePasswordViewModel(application: Application) : AndroidViewModel(application) {

    private var configuratorRepository: ConfiguratorRepository = ConfiguratorRepository()
    var currentFirebaseUser: FirebaseUser? = null

    var oldPassword: MutableState<String> = mutableStateOf("")
    var newPassword: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    suspend fun changePassword(resultViewError: MutableState<ViewError>) {
        resultViewError.value = ValidationService.isUserChangePassword(
            oldPassword = oldPassword.value,
            newPassword = newPassword.value,
            repeatedPassword = repeatedPassword.value,
            application = getApplication<Application>()
        )
        if (!resultViewError.value.isError.value
        ) {
            resultViewError.value =
                configuratorRepository.passwordVerificationUser(oldPassword.value, application = getApplication())
            if (!resultViewError.value.isError.value) {
                passwordUpdateUser(newPassword = newPassword.value)
                currentFirebaseUser = configuratorRepository.getCurrentUser()
            }
        }
    }
}