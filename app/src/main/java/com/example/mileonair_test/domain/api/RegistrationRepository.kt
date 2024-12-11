package com.example.mileonair_test.domain.api

import com.example.mileonair_test.domain.model.RegistrationData

interface RegistrationRepository {
    suspend fun saveRegistrationData(data: RegistrationData)
}