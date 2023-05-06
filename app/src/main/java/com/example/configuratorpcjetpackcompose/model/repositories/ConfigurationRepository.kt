package com.example.configuratorpcjetpackcompose.model.repositories

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.services.ConfigurationService
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService

class ConfigurationRepository {

    suspend fun getListAccessoryFromDB(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return ConfigurationService.getListAccessoryFromDB(classAccessoryType = classAccessoryType)
    }

    suspend fun getAccessoriesImage(uriAccessory: String): Uri {
        return ConfigurationService.getAccessoriesImage(uriAccessory = uriAccessory)
    }

    suspend fun getAccessoryFromDB(
        idAccessory: String,
        classAccessoryType: Class<out Accessory>
    ): Accessory {
        return ConfigurationService.getAccessoryFromDB(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun saveConfigurationToDB(configuration: Configuration) {
        ConfigurationService.saveConfigurationToDB(configuration)
    }

    suspend fun loadAllConfigurationsForUserFormDB(): List<Configuration> {
        return ConfigurationService.loadAllConfigurationsForUserFormDB()
    }

}