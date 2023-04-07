package com.example.configuratorpcjetpackcompose.services

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.Cpu
import com.example.configuratorpcjetpackcompose.model.Motherboard
import com.example.configuratorpcjetpackcompose.model.User
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import java.lang.ref.WeakReference

object FirebaseFireStoreService {
    private val fireStoreDatabaseWeakRef = WeakReference(FirebaseFirestore.getInstance())

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
}