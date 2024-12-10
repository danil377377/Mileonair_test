package com.example.mileonair_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.mileonair_test.ui.composable.BaseLayout
import com.example.mileonair_test.ui.composable.ProfileScreen
import com.example.mileonair_test.ui.composable.RegistrationForBankCustomerScreen
import com.example.mileonair_test.ui.theme.Mileonair_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var numberFromBank by remember { mutableStateOf(TextFieldValue("")) }
            var codeFromBank by remember { mutableStateOf(TextFieldValue("")) }
            var name by remember { mutableStateOf(TextFieldValue("")) }
            var surname by remember { mutableStateOf(TextFieldValue("")) }
            Mileonair_testTheme {
                Scaffold(
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    colorResource(R.color.bacground_gradient_from),
                                    colorResource(R.color.bacground_gradient_from)
                                )
                            )
                        )
                ) { innerPadding ->
                    BaseLayout(
                        modifier = Modifier.padding(innerPadding),
                        onBack = {}
                    ) {

                            RegistrationForBankCustomerScreen(numberFromBankProvider = { numberFromBank },
                                codeFromBankProvider = { codeFromBank },
                                nameProvider = { name },
                                surnameProvider = { surname },
                                onNameInputChange = { name = it },
                                onSurnameInputChange = { surname = it },
                                onNumberFromBankInputChange = { numberFromBank = it },
                                onCodeFromBankInputChange = { codeFromBank = it })

                    }

                }
            }
        }
    }
}


