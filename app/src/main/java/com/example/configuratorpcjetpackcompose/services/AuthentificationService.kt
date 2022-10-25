package com.example.configuratorpcjetpackcompose.services

import com.example.configuratorpcjetpackcompose.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import java.lang.ref.WeakReference


object AuthenticationService {

    private val firebaseAuthWeakRef = WeakReference(FirebaseAuth.getInstance())

    suspend fun createUser(email: String, password: String): FirebaseUser? {
        return if (firebaseAuthWeakRef.get() != null) {
            val firebaseUser =
                firebaseAuthWeakRef.get()!!.createUserWithEmailAndPassword(email, password)
                    .await().user
            if (firebaseUser != null) {
                FirebaseFireStoreService.addUserInDB(User(email = email))
            }
            firebaseUser
        } else{
            null
        }
    }

    suspend fun loginUser(email: String, password: String): FirebaseUser? {
        return if (firebaseAuthWeakRef.get() != null) {
            firebaseAuthWeakRef.get()!!.signInWithEmailAndPassword(email, password).await().user
        } else {
            null
        }
    }

}