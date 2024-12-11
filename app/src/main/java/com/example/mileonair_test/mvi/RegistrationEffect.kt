package com.example.mileonair_test.mvi

sealed class RegistrationEffect {
    data class UpdateState(val state: RegistrationState): RegistrationEffect()
}