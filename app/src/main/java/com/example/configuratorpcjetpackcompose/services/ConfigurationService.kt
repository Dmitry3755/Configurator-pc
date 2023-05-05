package com.example.configuratorpcjetpackcompose.services

suspend fun saveConfigurationToDB(configuration: com.example.configuratorpcjetpackcompose.model.dataclass.Configuration) {
     FirebaseFireStoreService.saveConfiguration(configuration)
}