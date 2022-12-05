package com.example.configuratorpcjetpackcompose.model

import android.app.Application
import com.example.configuratorpcjetpackcompose.services.AuthenticationService
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser

class ConfiguratorRepository {

    //private var authenticationService: AuthenticationService = AuthenticationService()

    suspend fun createUser(email: String, password: String): ViewError {
        return AuthenticationService.createUser(email, password)
    }

    suspend fun loginUser(email: String, password: String, application: Application): ViewError {
        return AuthenticationService.loginUser(email, password, application)
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return AuthenticationService.getCurrentUser()
    }

    suspend fun passwordVerificationUser(oldPassword: String, application: Application) : ViewError {
        return AuthenticationService.passwordVerificationUser(oldPassword, application)
    }
    suspend fun passwordUpdateUser(newPassword: String) : Task<Void> {
        return AuthenticationService.passwordUpdateUser(newPassword)
    }
}