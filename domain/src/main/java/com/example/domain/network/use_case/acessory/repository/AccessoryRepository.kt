package com.example.domain.network.use_case.acessory.repository

import android.net.Uri
import com.example.domain.model.Accessory

interface AccessoryRepository {
    suspend fun getAccessory(
        idAccessory: String,
        classAccessoryType: Class<out Accessory>
    ): Accessory
    suspend fun getAccessoryImage(uriAccessory: String): Uri
}