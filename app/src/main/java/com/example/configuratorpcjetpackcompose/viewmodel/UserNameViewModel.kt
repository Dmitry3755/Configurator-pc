package com.example.configuratorpcjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.services.getUserNameDb
import com.example.configuratorpcjetpackcompose.services.updateUserName

class UserNameViewModel() : ViewModel() {

    suspend fun userNameChange(userName: String) {
        updateUserName(userName)
    }
    suspend fun getUserName() : String {
        return  getUserNameDb()
    }

}