package com.example.mileonair_test.domain.impl

import com.example.mileonair_test.domain.api.RegistrationRepository
import com.example.mileonair_test.domain.model.RegistrationData
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SaveRegistrationDataUseCase @Inject constructor(private val repository: RegistrationRepository) {
    fun getState(): StateFlow<RegistrationData?> {
        return repository.registrationData
    }
            suspend operator fun invoke(data: RegistrationData) {
        repository.saveRegistrationData(data)
    }
}