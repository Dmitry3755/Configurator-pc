package com.example.domain.network.use_case.user.repository

interface UserNameRepository {
    suspend fun updateUserName(userName: String)
    suspend fun getUserNameDb() : String
}