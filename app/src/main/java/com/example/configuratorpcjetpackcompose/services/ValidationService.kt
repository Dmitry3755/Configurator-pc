package com.example.configuratorpcjetpackcompose.services

import android.util.Patterns

object ValidationService {

    fun isUserCredentialsValid(
        email: String,
        password: String,
        repeatedPassword: String
    ): Boolean {

       if((email.isEmpty()) && (Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
           return false
       }

        if(password.isEmpty() && (password.length < 6)){
            return false
        }

        return password == repeatedPassword
    }
}