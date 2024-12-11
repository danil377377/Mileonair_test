package com.example.mileonair_test.data.impl

import com.example.mileonair_test.domain.api.RegistrationRepository
import com.example.mileonair_test.domain.model.RegistrationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegistrationRepositoryImpl  @Inject constructor() : RegistrationRepository {
    private val _registrationData = MutableStateFlow<RegistrationData?>(null)
    val registrationData: StateFlow<RegistrationData?> = _registrationData

   override suspend fun saveRegistrationData(data: RegistrationData) {
        _registrationData.value = data
    }
}