package com.example.configuratorpcjetpackcompose.services

import com.example.configuratorpcjetpackcompose.model.User
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.ref.WeakReference

object FirebaseFireStoreService {
    private val fireStoreDatabaseWeakRef = WeakReference(FirebaseFirestore.getInstance())

    suspend fun addUserInDB(user: User) {
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").add(user)
        }
    }

}