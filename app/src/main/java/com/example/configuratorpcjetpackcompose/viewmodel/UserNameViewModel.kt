package com.example.configuratorpcjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.configuratorpcjetpackcompose.services.getUserNameDb
import com.example.configuratorpcjetpackcompose.services.updateUserName

class UserNameViewModel() : ViewModel() {

    fun userNameChange(userName: String) {
        if(userName != "")
        updateUserName(userName)
    }
    suspend fun getUserName() : String {
        return  getUserNameDb()
    }

}