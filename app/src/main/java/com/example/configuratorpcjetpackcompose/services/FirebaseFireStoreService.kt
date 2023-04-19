package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.core.net.toFile
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.User
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import java.lang.ref.WeakReference
import kotlin.coroutines.resume


object FirebaseFireStoreService {
    private val fireStoreDatabaseWeakRef = WeakReference(FirebaseFirestore.getInstance())
    private val fireStorageRef = FirebaseStorage.getInstance().getReference()

    fun addUserInDb(user: User) {
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").add(user)
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
