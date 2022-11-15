package com.example.configuratorpcjetpackcompose.services

import android.app.Application
import android.content.res.Resources
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.utils.Error

object ValidationService {

    fun isUserCredentialsValid(
        email: String,
        password: String,
        repeatedPassword: String,
        application: Application
    ): Error {

        if ((email.isEmpty()) || (!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            return Error(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.authentication_error_email_is_invalid)
                )
            )
        }

        if (password.isEmpty() || (password.length < 6)) {
            return Error(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.authentication_error_password_is_too_short)
                )
            )
        }

        if (password != repeatedPassword) {
            return Error(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    application.getString(R.string.authentication_error_password_does_not_match)
                )
            )
        }
        return Error(isError = mutableStateOf(false))
    }
}