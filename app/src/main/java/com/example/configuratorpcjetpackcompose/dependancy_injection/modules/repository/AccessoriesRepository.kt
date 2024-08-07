package com.example.configuratorpcjetpackcompose.dependancy_injection.modules.repository

import com.example.domain.network.use_case.acessory.repository.AccessoryRepository
import com.example.domain.network.use_case.acessory.repository.AllAccessoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface AccessoriesRepository {

    @Binds
    @ViewModelScoped
    fun bindsAllAccessoriesRepository(allAccessoriesRepository: com.example.domain.network.use_case.acessory.repository.AllAccessoriesRepository): com.example.domain.network.use_case.acessory.repository.AllAccessoriesRepository

    @Binds
    @ViewModelScoped
    fun bindsAccessoryRepository(accessoryRepository: com.example.domain.network.use_case.acessory.repository.AccessoryRepository): com.example.domain.network.use_case.acessory.repository.AccessoryRepository
}