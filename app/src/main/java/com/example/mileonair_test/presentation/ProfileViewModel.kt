package com.example.mileonair_test.presentation

import androidx.lifecycle.ViewModel
import com.example.mileonair_test.domain.api.RegistrationRepository
import com.example.mileonair_test.domain.impl.SaveRegistrationDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(saveRegistrationDataUseCase: SaveRegistrationDataUseCase) : ViewModel() {
    val registrationData = saveRegistrationDataUseCase.getState()
}