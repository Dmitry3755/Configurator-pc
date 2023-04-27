package com.example.configuratorpcjetpackcompose.services

import android.net.Uri
import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService.getAccessoriesImageFromStorage
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService.getAccessoriesListFromDb
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService.getAccessory

suspend fun getListAccessoryFromDB(classAccessoryType: Class<out Accessory>): List<Accessory> {
   return getAccessoriesListFromDb(classAccessoryType = classAccessoryType)
}
suspend fun getAccessoriesImage(uriAccessory: String) : Uri {
   return getAccessoriesImageFromStorage(uriAccessory = uriAccessory)
}
suspend fun getAccessoryFromDB(idAccessory: String, classAccessoryType: Class<out Accessory>) : Accessory {
   return getAccessory(idAccessory = idAccessory, classAccessoryType = classAccessoryType)
}