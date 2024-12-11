package com.example.mileonair_test.presentation

import androidx.lifecycle.ViewModel
import com.example.mileonair_test.domain.api.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val repository: RegistrationRepository) : ViewModel() {
    val registrationData = repository.registrationData
}