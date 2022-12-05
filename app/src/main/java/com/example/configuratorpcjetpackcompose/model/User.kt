package com.example.configuratorpcjetpackcompose.model

data class User(
    var email: String = "",
    var name: String = "",
    var avatarPath : String = ""
) /*TODO: Добавить поля User (name, avatar path) +
    TODO: changePassword() - изменение пароля (ввести старый пароль (relogin), потом новый 2 раза)
    TODO: фотокарточки грузить в storage (указывать на них ссылку в User)
*/