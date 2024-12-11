package com.example.mileonair_test.navigation

sealed class NavRoutes(val route:String){
    object Profile: NavRoutes("profile")
    object RegistartionForBankCustomer: NavRoutes("registartionForBankCustomer")
}