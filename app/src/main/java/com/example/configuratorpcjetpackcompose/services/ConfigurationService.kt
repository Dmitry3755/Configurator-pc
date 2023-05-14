package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration

object ConfigurationService {

    suspend fun getListAccessoryFromDB(classAccessoryType: Class<out Accessory>): List<Accessory> {
        return FirebaseFireStoreService.getAccessoriesCollectionListFromDb(classAccessoryType = classAccessoryType)
    }

    suspend fun getAccessoriesImage(uriAccessory: String): Uri {
        return FirebaseFireStoreService.getAccessoriesImageFromStorage(uriAccessory = uriAccessory)
    }

    suspend fun getAccessoryFromDB(
        idAccessory: String,
        classAccessoryType: Class<out Accessory>
    ): Accessory {
        return FirebaseFireStoreService.getAccessory(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun updateConfigurationOnDB(configuration: Configuration) {
        FirebaseFireStoreService.updateConfiguration(configuration)
    }

    suspend fun saveConfigurationToDB(configuration: com.example.configuratorpcjetpackcompose.model.data_class.Configuration) {
        FirebaseFireStoreService.saveConfiguration(configuration)
    }

    suspend fun loadAllConfigurationsForUserFormDB(): List<Configuration> {
        return FirebaseFireStoreService.loadAllConfigurationsForUser()
    }

}