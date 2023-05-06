package com.example.configuratorpcjetpackcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.configuratorpcjetpackcompose.model.repositories.UserRepository
import com.example.configuratorpcjetpackcompose.services.UserService
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.firebase.auth.FirebaseUser

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserRepository = UserRepository()

    var currentFirebaseUser: FirebaseUser? = null

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var oldPassword: MutableState<String> = mutableStateOf("")
    var newPassword: MutableState<String> = mutableStateOf("")
    var repeatedPassword: MutableState<String> = mutableStateOf("")

    suspend fun createUser(resultViewError: MutableState<ViewError>) {
        resultViewError.value = ValidationService.isUserCredentialsValid(
            email = email.value,
            password = password.value,
            repeatedPassword = repeatedPassword.value,
           // application = getApplication<Application>()
        )
        if (!resultViewError.value.isError.value) {
            resultViewError.value = userRepository.createUser(email.value, password.value)
            if (!resultViewError.value.isError.value) {
                currentFirebaseUser = userRepository.getCurrentUser()
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
            resultViewError.value = userRepository.loginUser(email.value, password.value, application = getApplication())
            if (!resultViewError.value.isError.value) {
                currentFirebaseUser = userRepository.getCurrentUser()
            }
        }
    }

    suspend fun changePassword(resultViewError: MutableState<ViewError>) {
        resultViewError.value = ValidationService.isUserChangePassword(
            oldPassword = oldPassword.value,
            newPassword = newPassword.value,
            repeatedPassword = repeatedPassword.value
        )
        if (!resultViewError.value.isError.value
        ) {
            resultViewError.value =
                userRepository.passwordVerificationUser(oldPassword.value, application = getApplication())
            if (!resultViewError.value.isError.value) {
                userRepository.passwordUpdateUser(newPassword = newPassword.value)
                currentFirebaseUser = userRepository.getCurrentUser()
            }
        }
    }

    suspend fun userNameChange(userName: String) {
        if (userName != "")
            userRepository.updateUserName(userName)
    }

    suspend fun getUserName(): String {
        return userRepository.getUserNameDb()
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return userRepository.getCurrentUser()
    }
}