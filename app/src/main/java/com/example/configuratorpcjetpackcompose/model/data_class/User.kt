package com.example.configuratorpcjetpackcompose.model.data_class

import com.google.firebase.firestore.PropertyName

data class User(
    @PropertyName("email")
    var _email: String = "",
    @PropertyName("name")
    var _name: String = "",
   @PropertyName("avatar_path")
    var _avatarPath : String = ""
) {
    var name: String
        get() = _name
        set(value) {
            _name = value
        }
    var email: String
        get() = _email
        set(value) {
            _email = value
        }
    var avatarPath: String
        get() = _avatarPath
        set(value) {
            _avatarPath = value
        }
}
