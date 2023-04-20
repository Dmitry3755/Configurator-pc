package com.example.configuratorpcjetpackcompose.services

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.User
import com.example.configuratorpcjetpackcompose.services.AuthenticationService.getCurrentUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import java.lang.ref.WeakReference
import kotlin.coroutines.resume


object FirebaseFireStoreService {
    private val fireStoreDatabaseWeakRef = WeakReference(FirebaseFirestore.getInstance())
    private val fireStorageRef = FirebaseStorage.getInstance().getReference()
    private val firebaseAuthWeakRef = WeakReference(FirebaseAuth.getInstance())

    suspend fun addUserInDb(user: User) {
        val userFire = hashMapOf(
            "name" to "User: " + getCurrentUser()!!.uid.substring(0, 7),
            "email" to user.email,
            "avatar_path" to user.avatarPath
        )
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").add(userFire)
        }
    }

    fun changeUserNameUpdate(userName: String) {

        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").document("j3ja8FbZZAETv9Ntb0w4")
                .update("name", userName)
        }
    }

    suspend fun getUserNameFromDb(): String {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection("Users")
                .whereEqualTo("email", firebaseAuthWeakRef.get()!!.currentUser!!.email!!).get()
                .addOnSuccessListener {
                    cancellableContinuation.resume(it.documents[0].toObject(User::class.java)!!._name)
                }
        }
    }

    suspend fun getAccessoriesListFromDb(classAccessoryType: Class<out Accessory>): List<Accessory> {
        val collectionPath: String = classAccessoryType.simpleName

        var listAccessories: List<Accessory> =
            fireStoreDatabaseWeakRef.get()!!.collection(collectionPath).get().await().map {
                it.toObject(classAccessoryType)
            }
        return listAccessories
    }

    suspend fun getAccessoriesImageFromStorage(uriAccessory: String): Uri {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStorageRef.child(uriAccessory).downloadUrl
                .addOnSuccessListener {
                    cancellableContinuation.resume(it)
                }
        }
    }
}
