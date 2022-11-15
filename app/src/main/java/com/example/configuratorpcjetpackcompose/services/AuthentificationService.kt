package com.example.configuratorpcjetpackcompose.services

import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import java.lang.ref.WeakReference
import kotlin.coroutines.resume
import com.example.configuratorpcjetpackcompose.utils.Error
import kotlinx.coroutines.*


object AuthenticationService {

    private val firebaseAuthWeakRef = WeakReference(FirebaseAuth.getInstance())

    suspend fun createUser(email: String, password: String): Error {
        return if (firebaseAuthWeakRef.get() != null) {
            suspendCancellableCoroutine { cancellableContinuation ->
                firebaseAuthWeakRef.get()!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                           GlobalScope.launch(Dispatchers.IO) {
                               FirebaseFireStoreService.addUserInDB(user = User(email = email))
                           }
                            cancellableContinuation.resume(Error(isError = mutableStateOf(false)))
                        } else {
                            cancellableContinuation.resume(
                                Error(
                                    isError = mutableStateOf(true),
                                    errorMessage = mutableStateOf(it.exception!!.message.toString())
                                )
                            )
                        }
                    }
            }

        } else {
            Error(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf("error")
            )
        }
    }

    suspend fun loginUser(email: String, password: String): Error {
        return if (firebaseAuthWeakRef.get() != null) {
            suspendCancellableCoroutine { cancellableContinuation ->
                firebaseAuthWeakRef.get()!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            cancellableContinuation.resume(Error(isError = mutableStateOf(false)))
                        } else {
                            cancellableContinuation.resume(
                                Error(
                                    isError = mutableStateOf(true),
                                    errorMessage = mutableStateOf(it.exception!!.message.toString())
                                )
                            )
                        }
                    }
            }

        } else {
            Error(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf("error")
            )
        }
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return if (firebaseAuthWeakRef.get() != null) {
            firebaseAuthWeakRef.get()!!.currentUser
        } else {
            null
        }
    }

}