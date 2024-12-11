package com.example.mileonair_test.mvi

data class RegistrationState(
    val name: String = "",
    val surname: String = "",
    val number: String = "",
    val code: String = "",
    val isButtonEnabled: Boolean = false,
    val nameError: Boolean = true,
    val surnameError: Boolean = true,
    val numberError: Boolean = false,
    val codeError: Boolean = true,
)
