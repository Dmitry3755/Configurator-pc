package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.data.model.entities.data_class.Configuration

object ConfigurationService {

    suspend fun getListAccessoryFromDB(classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>): List<com.example.data.entities.AccessoryApiResponse> {
        return FirebaseFireStoreService.getAccessoriesCollectionListFromDb(classAccessoryType = classAccessoryType)
    }

    suspend fun getAccessoriesImage(uriAccessory: String): Uri {
        return FirebaseFireStoreService.getAccessoriesImageFromStorage(uriAccessory = uriAccessory)
    }

    suspend fun getAccessoryFromDB(
        idAccessory: String,
        classAccessoryType: Class<out com.example.data.entities.AccessoryApiResponse>
    ): com.example.data.entities.AccessoryApiResponse {
        return FirebaseFireStoreService.getAccessory(
            idAccessory = idAccessory,
            classAccessoryType = classAccessoryType
        )
    }

    suspend fun updateConfigurationOnDB(configuration: com.example.data.model.entities.data_class.Configuration) {
        FirebaseFireStoreService.updateConfiguration(configuration)
    }

    suspend fun saveConfigurationToDB(configuration: com.example.data.model.entities.data_class.Configuration) {
        FirebaseFireStoreService.saveConfiguration(configuration)
    }

    suspend fun loadAllConfigurationsForUserFormDB(): List<com.example.data.model.entities.data_class.Configuration> {
        return FirebaseFireStoreService.loadAllConfigurationsForUser()
    }

}