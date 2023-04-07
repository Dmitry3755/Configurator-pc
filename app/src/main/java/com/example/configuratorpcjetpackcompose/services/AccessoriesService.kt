package com.example.configuratorpcjetpackcompose.services

import com.example.configuratorpcjetpackcompose.model.Accessory
import com.example.configuratorpcjetpackcompose.model.Cpu
import com.example.configuratorpcjetpackcompose.model.User
import com.example.configuratorpcjetpackcompose.services.FirebaseFireStoreService.getAccessoriesListFromDb
import com.example.configuratorpcjetpackcompose.utils.ConfigurationElementEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

suspend fun getListAccessoryFromDB(classAccessoryType: Class<out Accessory>): List<Accessory> {
   return getAccessoriesListFromDb(classAccessoryType = classAccessoryType)
}