package com.example.mileonair_test.domain.api

import com.example.mileonair_test.domain.model.RegistrationData
import kotlinx.coroutines.flow.StateFlow

interface RegistrationRepository {
    val registrationData: StateFlow<RegistrationData?>
    suspend fun saveRegistrationData(data: RegistrationData)
}