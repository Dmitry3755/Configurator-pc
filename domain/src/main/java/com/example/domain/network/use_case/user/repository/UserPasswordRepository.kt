package com.example.domain.network.use_case.user.repository

import android.app.Application

interface UserPasswordRepository {
    suspend fun verificationPassword(oldPassword: String, application: Application)
    suspend fun updatePassword(newPassword: String)
}