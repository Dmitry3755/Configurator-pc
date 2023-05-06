package com.example.configuratorpcjetpackcompose.model.repositories

import android.app.Application
import com.example.configuratorpcjetpackcompose.services.AuthenticationService
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService
import com.example.configuratorpcjetpackcompose.services.UserService
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser

class UserRepository {
    suspend fun createUser(email: String, password: String): ViewError {
        return AuthenticationService.createUser(email, password)
    }

    suspend fun loginUser(email: String, password: String, application: Application): ViewError {
        return AuthenticationService.loginUser(email, password, application)
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return AuthenticationService.getCurrentUser()
    }

    suspend fun passwordVerificationUser(oldPassword: String, application: Application): ViewError {
        return AuthenticationService.passwordVerificationUser(oldPassword, application)
    }

    suspend fun passwordUpdateUser(newPassword: String): Task<Void> {
        return AuthenticationService.passwordUpdateUser(newPassword)
    }

    suspend fun updateUserName(userName: String) {
        return UserService.updateUserNameInDb(userName)
    }

    suspend fun getUserNameDb(): String {
        return UserService.getUserNameDb()
    }

}