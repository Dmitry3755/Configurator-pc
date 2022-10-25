package com.example.configuratorpcjetpackcompose.model

import com.example.configuratorpcjetpackcompose.services.AuthenticationService
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class ConfiguratorRepository {

    //private var authenticationService: AuthenticationService = AuthenticationService()

    suspend fun createUser(email: String, password: String): FirebaseUser? {
        return AuthenticationService.createUser(email, password)
    }

    suspend fun loginUser(email: String, password: String): FirebaseUser? {
        return AuthenticationService.loginUser(email, password)
    }

}