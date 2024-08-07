package com.example.configuratorpcjetpackcompose.dependancy_injection.modules.repository

import com.example.configuratorpcjetpackcompose.dependancy_injection.modules.FirebaseModule
import com.example.domain.network.use_case.user.repository.UserAuthorizationRepository
import com.example.domain.network.use_case.user.repository.UserNameRepository
import com.example.domain.network.use_case.user.repository.UserPasswordRepository
import com.example.domain.network.use_case.user.repository.UserRegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module(includes = [FirebaseModule::class])
@InstallIn(ViewModelComponent::class)
interface UserRepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindsUserAuthorizationRepository(userAuthorizationRepository : com.example.domain.network.use_case.user.repository.UserAuthorizationRepository) : com.example.domain.network.use_case.user.repository.UserAuthorizationRepository

    @Binds
    @ViewModelScoped
    fun bindsUserNameRepository(userNameRepository : com.example.domain.network.use_case.user.repository.UserNameRepository) : com.example.domain.network.use_case.user.repository.UserNameRepository

    @Binds
    @ViewModelScoped
    fun bindsUserPasswordRepository(userPasswordRepository : com.example.domain.network.use_case.user.repository.UserPasswordRepository) : com.example.domain.network.use_case.user.repository.UserPasswordRepository

    @Binds
    @ViewModelScoped
    fun bindsUserRegistrationRepository(userRegistrationRepository : com.example.domain.network.use_case.user.repository.UserRegistrationRepository) : com.example.domain.network.use_case.user.repository.UserRegistrationRepository

}