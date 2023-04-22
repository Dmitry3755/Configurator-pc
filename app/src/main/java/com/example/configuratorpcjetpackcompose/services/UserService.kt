package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory

suspend fun getUserNameDb() : String {
    return FirebaseFireStoreService.getUserNameFromDb()
}
fun updateUserName(userName: String) {
     FirebaseFireStoreService.changeUserNameUpdate(userName = userName)
}
