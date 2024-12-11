package com.example.mileonair_test.mvi

sealed class RegistrationAction {
    data class NameChanged(val name: String) : RegistrationAction()
    data class SurnameChanged(val surname: String) : RegistrationAction()
    data class NumberChanged(val number: String) : RegistrationAction()
    data class CodeChanged(val code: String) : RegistrationAction()
    object Submit : RegistrationAction()
}