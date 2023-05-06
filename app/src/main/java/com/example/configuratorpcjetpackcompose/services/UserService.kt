package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory

object UserService {

    suspend fun updateUserNameInDb(userName: String) {
        FirebaseFireStoreService.changeUserNameUpdate(userName = userName)
    }

    suspend fun getUserNameDb(): String {
        return FirebaseFireStoreService.getUserNameFromDb()
    }

}
