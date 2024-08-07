package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.data.model.entities.Case
import com.example.data.model.entities.data_class.Configuration
import com.example.data.model.entities.CoolerForCase
import com.example.data.model.entities.CoolerForCpu
import com.example.data.model.entities.Cpu
import com.example.data.model.entities.Dimm
import com.example.data.model.entities.HardDrive
import com.example.data.model.entities.Monitor
import com.example.data.model.entities.Motherboard
import com.example.data.model.entities.PowerSupplyUnit
import com.example.data.model.entities.SoDimm
import com.example.data.model.entities.SoundCard
import com.example.data.model.entities.Ssd
import com.example.data.model.entities.User
import com.example.data.model.entities.VideoCard
import com.example.data.model.entities.data_class.toFbConfiguration
import com.example.data.entities.FbConfiguration
import com.example.data.entities.toConfiguration
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

    suspend fun addUserInDb(user: com.example.data.model.entities.User) {
        val userFire = hashMapOf(
            "name" to "User: " + getCurrentUser()!!.uid.substring(0, 7),
            "email" to user.email,
            "avatar_path" to user.avatarPath
        )
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").add(userFire)
        }
    }

    private suspend fun getUserId(): String {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection("Users")
                .whereEqualTo("email", firebaseAuthWeakRef.get()!!.currentUser!!.email!!).get()
                .addOnSuccessListener {
                    cancellableContinuation.resume(it.documents[0].id)
                }
        }
    }

    suspend fun changeUserNameUpdate(userName: String) {
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").document(getUserId())
                .update("name", userName)
        }
    }

    suspend fun getUserNameFromDb(): String {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection("Users")
                .whereEqualTo("email", firebaseAuthWeakRef.get()!!.currentUser!!.email!!).get()
                .addOnSuccessListener {
                    cancellableContinuation.resume(it.documents[0].toObject(com.example.data.model.entities.User::class.java)!!._name)
                }
        }
    }

    suspend fun getAccessoriesCollectionListFromDb(classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>): List<com.example.data.entities.AccessoryApiResponse> {
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
        classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>
    ): com.example.data.entities.AccessoryApiResponse {
        return suspendCancellableCoroutine { cancellableContinuation ->
            fireStoreDatabaseWeakRef.get()!!.collection(classAccessoryType.simpleName)
                .document(idAccessory).get().addOnSuccessListener { document ->
                    cancellableContinuation.resume(
                        document.toObject(classAccessoryType)!!.also { accessory ->
                            accessory._idAccessory = document.id
                            accessory._nameAccessory = accessory.name
                            accessory._priceAccessory = accessory.price
                            accessory._descriptionAccessory = accessory.description
                            accessory._uriAccessory = accessory.uri
                        })
                }
        }
    }

    suspend fun getAccessoriesList(
        idAccessoryList: MutableList<String>,
        classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>
    ): MutableList<out com.example.data.entities.AccessoryApiResponse> {
        var accessoryList: MutableList<com.example.data.entities.AccessoryApiResponse> = mutableListOf()
        for (idAccessory in idAccessoryList) {
            accessoryList.add(suspendCancellableCoroutine { cancellableContinuation ->
                fireStoreDatabaseWeakRef.get()!!.collection(classAccessoryType.simpleName)
                    .document(idAccessory).get().addOnSuccessListener { document ->
                        cancellableContinuation.resume(
                            document.toObject(classAccessoryType)!!.also { accessory ->
                                accessory._idAccessory = document.id
                                accessory._nameAccessory = accessory.name
                                accessory._priceAccessory = accessory.price
                                accessory._descriptionAccessory = accessory.description
                                accessory._uriAccessory = accessory.uri
                            })
                    }
            })
        }
        var a= 0
        return accessoryList
    }

    suspend fun updateConfiguration(configuration: com.example.data.model.entities.data_class.Configuration) {
        if (fireStoreDatabaseWeakRef.get() != null) {
            var fbConfiguration = configuration.toFbConfiguration()
            val userFire = hashMapOf(
                "caseId" to fbConfiguration.caseId,
                "coolerForCaseIdsList" to fbConfiguration.coolerForCaseIdsList
            )

            fireStoreDatabaseWeakRef.get()!!.collection("Users").document(getUserId())
                .collection("Configurations").document().update(userFire)
        }
    }

    suspend fun saveConfiguration(configuration: com.example.data.model.entities.data_class.Configuration) {
        if (fireStoreDatabaseWeakRef.get() != null) {
            fireStoreDatabaseWeakRef.get()!!.collection("Users").document(getUserId())
                .collection("Configurations").document().set(configuration.toFbConfiguration())
        }
    }

    suspend fun loadAllConfigurationsForUser(): List<com.example.data.model.entities.data_class.Configuration> {
        return fireStoreDatabaseWeakRef.get()!!.collection("Users").document(getUserId())
            .collection("Configurations").get().await().map { snapshot ->
                snapshot.toObject(FbConfiguration::class.java).let { fbConfiguration ->
                    fbConfiguration.toConfiguration(
                        nameConfiguration = snapshot.get("name").toString(),
                        isFavorite = snapshot.get("is_favorite").toString().toBoolean(),
                        cpu = getAccessory(
                            fbConfiguration.cpuId,
                            com.example.data.model.entities.Cpu::class.java
                        ) as com.example.data.model.entities.Cpu,
                        motherboard = getAccessory(
                            fbConfiguration.motherboardId,
                            com.example.data.model.entities.Motherboard::class.java
                        ) as com.example.data.model.entities.Motherboard,
                        case = getAccessory(
                            fbConfiguration.caseId,
                            com.example.data.model.entities.Case::class.java
                        ) as com.example.data.model.entities.Case,
                        soundCard = if (fbConfiguration.soundCardId != "") {
                            getAccessory(
                                fbConfiguration.soundCardId,
                                com.example.data.model.entities.SoundCard::class.java
                            ) as com.example.data.model.entities.SoundCard
                        } else {
                            com.example.data.model.entities.SoundCard()
                        },
                        powerSupplyUnit = getAccessory(
                            fbConfiguration.powerSupplyUnitId,
                            com.example.data.model.entities.PowerSupplyUnit::class.java
                        ) as com.example.data.model.entities.PowerSupplyUnit,
                        coolerForCpu = getAccessory(
                            fbConfiguration.coolerForCpuId,
                            com.example.data.model.entities.CoolerForCpu::class.java
                        ) as com.example.data.model.entities.CoolerForCpu,
                        coolerForCaseIdsList = if (fbConfiguration.coolerForCaseIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.coolerForCaseIdsList,
                                com.example.data.model.entities.CoolerForCase::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.CoolerForCase }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        dimmIdsList = if (fbConfiguration.dimmIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.dimmIdsList,
                                com.example.data.model.entities.Dimm::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.Dimm }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        soDimmIdsList = if (fbConfiguration.soDimmIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.soDimmIdsList,
                                com.example.data.model.entities.SoDimm::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.SoDimm }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        hardDriveIdsList = if (fbConfiguration.hardDriveIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.hardDriveIdsList,
                                com.example.data.model.entities.HardDrive::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.HardDrive }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        ssdIdsList = if (fbConfiguration.ssdIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.ssdIdsList,
                                com.example.data.model.entities.Ssd::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.Ssd }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        monitorIdsList = if (fbConfiguration.monitorIdsList.isNotEmpty()) {
                            getAccessoriesList(
                                fbConfiguration.monitorIdsList,
                                com.example.data.model.entities.Monitor::class.java
                            ).map { snapshot -> snapshot as com.example.data.model.entities.Monitor }.toMutableList()
                        } else {
                            mutableListOf()
                        },
                        videoCardIdsList =
                        getAccessoriesList(
                            fbConfiguration.videoCardIdsList,
                            com.example.data.model.entities.VideoCard::class.java
                        ).map { snapshot -> snapshot as com.example.data.model.entities.VideoCard }.toMutableList()
                    )
                }
            }
    }

}

