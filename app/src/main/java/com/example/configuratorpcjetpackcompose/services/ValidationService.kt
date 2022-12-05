package com.example.configuratorpcjetpackcompose.services

import android.app.Application
import android.content.res.Resources
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.ConfiguratorRepository
import com.example.configuratorpcjetpackcompose.utils.DataResult
import com.example.configuratorpcjetpackcompose.utils.ViewError

object ValidationService {

    fun isUserCredentialsValid(
        email: String,
        password: String,
        repeatedPassword: String,
        application: Application
    ): ViewError {

        if ((email.isEmpty()) || (!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_email_is_invalid)
                )
            )
        }

        if (password.isEmpty() || (password.length < 6)) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (password != repeatedPassword) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_password_does_not_match)
                )
            )
        }
        return ViewError(isError = mutableStateOf(false))
    }

    fun isUserChangePassword(
        oldPassword: String,
        newPassword: String,
        repeatedPassword: String,
        application: Application
    ): ViewError {

        if (oldPassword.isEmpty()) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (newPassword.isEmpty() || (newPassword.length < 6)) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_password_is_too_short)
                )
            )
        }

        if (newPassword != repeatedPassword) {
            return ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.error_authentication_password_does_not_match)
                )
            )
        }
        return ViewError(isError = mutableStateOf(false))
    }
}