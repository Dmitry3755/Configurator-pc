package com.example.domain.model

data class User(
    val uid: String,
    var email: String?,
    var name: String?,
    var password : String?,
    var avatarPath : String?
)
