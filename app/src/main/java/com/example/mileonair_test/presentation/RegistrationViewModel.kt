package com.example.mileonair_test.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mileonair_test.domain.api.RegistrationRepository
import com.example.mileonair_test.domain.impl.SaveRegistrationDataUseCase
import com.example.mileonair_test.domain.model.RegistrationData
import com.example.mileonair_test.mvi.RegistrationAction
import com.example.mileonair_test.mvi.RegistrationEffect
import com.example.mileonair_test.mvi.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val saveRegistrationDataUseCase: SaveRegistrationDataUseCase) : ViewModel() {
    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<RegistrationEffect>()
    val effect: SharedFlow<RegistrationEffect> = _effect

    fun dispatch(action: RegistrationAction) {
        viewModelScope.launch {
            when (action) {
                is RegistrationAction.NameChanged -> {
                    _state.value = _state.value.copy(name = action.name)
                    validateAndEnableButton()
                }
                is RegistrationAction.SurnameChanged -> {
                    _state.value = _state.value.copy(surname = action.surname)
                    validateAndEnableButton()
                }
                is RegistrationAction.NumberChanged -> {
                    _state.value = _state.value.copy(number = action.number)
                    validateAndEnableButton()
                }
                is RegistrationAction.CodeChanged -> {
                    _state.value = _state.value.copy(code = action.code)
                    validateAndEnableButton()
                }
                is RegistrationAction.Submit -> {
                    val data = RegistrationData(
                        name = _state.value.name,
                        surname = _state.value.surname,
                        number = _state.value.number,
                        code = _state.value.code
                    )
                    saveRegistrationDataUseCase(data)
                    _effect.emit(RegistrationEffect.UpdateState(state.value))
                }
            }
        }
    }

    private fun validateAndEnableButton() {
        val newState = _state.value.copy(
            isButtonEnabled = (isNameCorrect(_state.value.name) &&
                    isSurnameCorrect(_state.value.surname) &&
                    isNumberCorrect(_state.value.number) &&
                    isCodeCorrect(_state.value.code))
        )
        _state.value = newState
    }
    fun isNumberCorrect(value: String): Boolean{
        return value.isNotBlank() && value.length == 16
    }
    fun isCodeCorrect(value: String): Boolean{
        return value.isNotBlank()
    }
    fun isNameCorrect(value: String): Boolean{
        return value.isNotBlank()
    }
    fun isSurnameCorrect(value: String): Boolean{
        return value.isNotBlank()
    }
}