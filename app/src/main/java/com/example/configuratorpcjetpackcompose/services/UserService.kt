package com.example.configuratorpcjetpackcompose.services

object UserService {

    suspend fun updateUserNameInDb(userName: String) {
        FirebaseFireStoreService.changeUserNameUpdate(userName = userName)
    }

    suspend fun getUserNameDb(): String {
        return FirebaseFireStoreService.getUserNameFromDb()
    }

}
