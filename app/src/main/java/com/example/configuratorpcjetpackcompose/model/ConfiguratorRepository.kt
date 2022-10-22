package com.example.configuratorpcjetpackcompose.model

import com.example.configuratorpcjetpackcompose.services.AuthenticationService

class ConfiguratorRepository {

    private var authenticationService: AuthenticationService = AuthenticationService()

    fun createUser(email: String, password: String) {
        authenticationService.createUser(email, password)
    }

}