package com.example.domain.network.use_case.user.repository

interface UserRegistrationRepository {
    suspend fun registration(email: String, password: String)
}