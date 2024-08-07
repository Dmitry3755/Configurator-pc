package com.example.data.network.user_repository_impl.authorization

import android.app.Application
import com.example.data.mappers.toUser
import com.example.domain.model.User
import com.example.domain.network.use_case.user.repository.UserAuthorizationRepository
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class UserAuthorizationRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) : UserAuthorizationRepository {
    override suspend fun authorization(email: String, password: String, application: Application) {
        try {

        }
        catch(e : Exception) {

        }
    }

    override val currentUser: User?
        get() = firebaseAuth.currentUser?.toUser(null)
}