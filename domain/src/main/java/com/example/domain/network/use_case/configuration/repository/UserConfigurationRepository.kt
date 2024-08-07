package com.example.domain.network.use_case.configuration.repository

import com.example.domain.model.Configuration

interface UserConfigurationRepository {
    suspend fun updateConfiguration(configuration: Configuration)

    suspend fun saveConfiguration(configuration: Configuration)

}