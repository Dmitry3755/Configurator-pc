package com.example.domain.network.use_case.configuration.repository

import com.example.domain.model.Configuration

interface AllUserConfigurationsRepository {
    suspend fun getListConfigurations(): List<Configuration>
}