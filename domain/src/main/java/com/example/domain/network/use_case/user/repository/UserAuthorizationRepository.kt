package com.example.domain.network.use_case.user.repository

import android.app.Application
import com.example.domain.model.User

interface UserAuthorizationRepository {
    val currentUser : User?
    suspend fun authorization(email: String, password: String, application: Application)
}