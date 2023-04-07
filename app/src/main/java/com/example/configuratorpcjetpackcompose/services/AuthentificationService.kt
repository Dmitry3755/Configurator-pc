package com.example.configuratorpcjetpackcompose.services

import android.app.Application
import android.content.res.Resources
import androidx.compose.runtime.mutableStateOf
import com.example.configuratorpcjetpackcompose.R
import com.example.configuratorpcjetpackcompose.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.lang.ref.WeakReference
import kotlin.coroutines.resume
import com.example.configuratorpcjetpackcompose.utils.ViewError
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.EmailAuthProvider
import kotlinx.coroutines.*


object AuthenticationService {

    private val firebaseAuthWeakRef = WeakReference(FirebaseAuth.getInstance())

    suspend fun createUser(email: String, password: String): ViewError {
        return if (firebaseAuthWeakRef.get() != null) {
            suspendCancellableCoroutine { cancellableContinuation ->
                firebaseAuthWeakRef.get()!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            GlobalScope.launch(Dispatchers.IO) {
                                FirebaseFireStoreService.addUserInDb(user = User(email = email))
                            }
                            cancellableContinuation.resume(ViewError(isError = mutableStateOf(false)))
                        } else {
                            cancellableContinuation.resume(
                                ViewError(
                                    isError = mutableStateOf(true),
                                    errorMessage = mutableStateOf(it.exception!!.message.toString())
                                )
                            )
                        }
                    }
            }

        } else {
            ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf("error")
            )
        }
    }

    suspend fun loginUser(email: String, password: String, application: Application): ViewError {
        return if (firebaseAuthWeakRef.get() != null) {
            suspendCancellableCoroutine { cancellableContinuation ->
                firebaseAuthWeakRef.get()!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            cancellableContinuation.resume(ViewError(isError = mutableStateOf(false)))
                        } else {
                            cancellableContinuation.resume(
                                ViewError(
                                    isError = mutableStateOf(true),
                                    errorMessage = mutableStateOf(application.getString(R.string.error_authentication_password_is_invalid))
                                )
                            )
                        }
                    }
            }

        } else {
            ViewError(
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

    suspend fun passwordVerificationUser(oldPassword: String, application: Application): ViewError {
        val user = getCurrentUser()
        return if (user == null) {
            ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    Resources.getSystem()
                        .getString(R.string.error_change_password_current_user_does_not_exist)
                )
            )
        } else {
            val credential = EmailAuthProvider.getCredential(
                user.email!!,
                oldPassword
            )
            suspendCancellableCoroutine { cancellableContinuation ->
                user.reauthenticate(credential)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            cancellableContinuation.resume(ViewError(isError = mutableStateOf(false)))
                        } else {
                            cancellableContinuation.resume(
                                ViewError(
                                    isError = mutableStateOf(true),
                                    errorMessage = mutableStateOf(
                                        application.getString(R.string.error_change_password_old_password_is_invalid)
                                    )
                                )
                            )
                        }
                    }
            }
        }
    }

    suspend fun passwordUpdateUser(newPassword: String): Task<Void> {
        val user = getCurrentUser()

        return user!!.updatePassword(newPassword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                ViewError(isError = mutableStateOf(false))
            } else {
                ViewError(
                    isError = mutableStateOf(true),
                    errorMessage = mutableStateOf(task.exception!!.message.toString())
                )
            }
        }
    }
}