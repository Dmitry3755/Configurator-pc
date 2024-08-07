package com.example.configuratorpcjetpackcompose.dependancy_injection.modules

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FirebaseModule {

    @Provides
    fun getFirebaseAuth() : FirebaseAuth = FirebaseAuth.getInstance()

}