package com.example.data.mappers

import com.example.domain.model.User
import com.google.firebase.auth.FirebaseUser

fun FirebaseUser.toUser(password : String?) : User {
    return User(
        uid = uid,
        name = displayName,
        email = email,
        avatarPath = photoUrl.toString(),
        password = password
    )
}