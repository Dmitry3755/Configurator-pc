package com.example.configuratorpcjetpackcompose.model

import com.example.configuratorpcjetpackcompose.services.AuthenticationService
import com.example.configuratorpcjetpackcompose.utils.Error
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class ConfiguratorRepository {

    //private var authenticationService: AuthenticationService = AuthenticationService()

    suspend fun createUser(email: String, password: String): Error {
        return AuthenticationService.createUser(email, password)
    }

    suspend fun loginUser(email: String, password: String): Error {
        return AuthenticationService.loginUser(email, password)
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return AuthenticationService.getCurrentUser()
    }
}