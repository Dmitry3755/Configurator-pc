package com.example.domain.network.use_case.acessory.repository

import com.example.domain.model.Accessory

interface AllAccessoriesRepository {
    suspend fun getListAccessoryFromDB(classAccessoryType: Class<out Accessory>): List<Accessory>
}