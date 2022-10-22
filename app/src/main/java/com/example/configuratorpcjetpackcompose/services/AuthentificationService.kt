package com.example.configuratorpcjetpackcompose.services

import com.google.firebase.auth.FirebaseAuth


class AuthenticationService {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun createUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener{}
    }

}