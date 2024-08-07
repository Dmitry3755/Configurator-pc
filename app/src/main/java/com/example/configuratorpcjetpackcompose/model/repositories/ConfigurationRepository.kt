package com.example.configuratorpcjetpackcompose.model.repositories

import android.net.Uri
import com.example.configuratorpcjetpackcompose.services.ConfigurationService

class ConfigurationRepository {

    suspend fun getListAccessoryFromDB(classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>): List<com.example.data.entities.AccessoryApiResponse> {
        return ConfigurationService.getListAccessoryFromDB(classAccessoryType = classAccessoryType)
    }

    suspend fun getAccessoriesImage(uriAccessory: String): Uri {
        return ConfigurationService.getAccessoriesImage(uriAccessory = uriAccessory)
    }

    suspend fun getAccessoryFromDB(
        idAccessory: String,
        classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>
    ): com.example.data.entities.AccessoryApiResponse {
        return ConfigurationService.getAccessoryFromDB(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun updateConfigurationOnDB(configuration: com.example.data.model.entities.data_class.Configuration) {
        ConfigurationService.updateConfigurationOnDB(configuration)
    }

    suspend fun saveConfigurationToDB(configuration: com.example.data.model.entities.data_class.Configuration) {
        ConfigurationService.saveConfigurationToDB(configuration)
    }

    suspend fun loadAllConfigurationsForUserFormDB(): List<com.example.data.model.entities.data_class.Configuration> {
        return ConfigurationService.loadAllConfigurationsForUserFormDB()
    }

}