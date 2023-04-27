package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.dataclass.User
import com.example.configuratorpcjetpackcompose.services.AuthenticationService.getCurrentUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

    suspend fun changeUserNameUpdate(userName: String) {

        val userID = suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection("Users")
                .whereEqualTo("email", firebaseAuthWeakRef.get()!!.currentUser!!.email!!).get()
                .addOnSuccessListener {
                    cancellableContinuation.resume(it.documents[0].id)
                }
        }

        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").document(userID)
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
        return fireStoreDatabaseWeakRef.get()!!.collection(classAccessoryType.simpleName).get()
            .await()
            .map { snapshot ->
                snapshot.toObject(classAccessoryType).also { accessory ->
                    accessory._idAccessory = snapshot.id
                    accessory._nameAccessory = accessory.name
                    accessory._priceAccessory = accessory.price
                    accessory._descriptionAccessory = accessory.description
                    accessory._uriAccessory = accessory.uri
                }
            }
    }

    suspend fun getAccessoriesImageFromStorage(uriAccessory: String): Uri {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStorageRef.child(uriAccessory).downloadUrl
                .addOnSuccessListener {
                    cancellableContinuation.resume(it)
                }
        }
    }

    suspend fun getAccessory(
        idAccessory: String,
        classAccessoryType: Class<out Accessory>
    ): Accessory {
        return  suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection(classAccessoryType.simpleName)
                .document(idAccessory).get().addOnSuccessListener { document ->
                    cancellableContinuation.resume(document.toObject(classAccessoryType)!!)
                }
        }
    }
}

