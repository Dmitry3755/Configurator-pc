package com.example.configuratorpcjetpackcompose.dependancy_injection.modules.repository

import com.example.domain.network.use_case.configuration.repository.AllUserConfigurationsRepository
import com.example.domain.network.use_case.configuration.repository.UserConfigurationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface ConfigurationRepository {
    @Binds
    @ViewModelScoped
    fun bindsAllUserConfigurationsRepository(allUserConfigurationsRepository : com.example.domain.network.use_case.configuration.repository.AllUserConfigurationsRepository) : com.example.domain.network.use_case.configuration.repository.AllUserConfigurationsRepository

    @Binds
    @ViewModelScoped
    fun bindsUserConfigurationRepository(userConfigurationRepository : com.example.domain.network.use_case.configuration.repository.UserConfigurationRepository) : com.example.domain.network.use_case.configuration.repository.UserConfigurationRepository
}