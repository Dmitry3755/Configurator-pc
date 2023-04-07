package com.example.configuratorpcjetpackcompose.services

import android.app.Application
import android.content.res.Resources
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.utils.AppResources
import com.example.configuratorpcjetpackcompose.utils.DataResult
import com.example.configuratorpcjetpackcompose.utils.ViewError

object ValidationService {

    fun isUserCredentialsValid(
        email: String,
        password: String,
        repeatedPassword: String
    ): ViewError {

        if ((email.isEmpty()) || (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches())) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_email_is_invalid)
                )
            )
        }

        if (password.isEmpty() || (password.length < 6)) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (password != repeatedPassword) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_password_does_not_match)
                )
            )
        }
        return ViewError(isError = mutableStateOf(false))
    }

    fun isUserChangePassword(
        oldPassword: String,
        newPassword: String,
        repeatedPassword: String
    ): ViewError { // 1

        if (oldPassword.isEmpty()) { // 2
            return ViewError( //6
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (newPassword.isEmpty() || (newPassword.length < 6)) {    //3 //4
            return ViewError(   //5
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (newPassword != repeatedPassword) {  // 5
            return ViewError(   // 6
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_authentication_password_does_not_match)
                )
            )
        }
        return ViewError(isError = mutableStateOf(false))   //6
    }
}