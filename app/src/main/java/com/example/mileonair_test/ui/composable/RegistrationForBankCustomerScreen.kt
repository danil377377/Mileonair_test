package com.example.mileonair_test.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mileonair_test.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RegistrationForBankCustomerScreen(
    numberFromBankProvider: () -> TextFieldValue,
    codeFromBankProvider: () -> TextFieldValue,
    nameProvider: () -> TextFieldValue,
    surnameProvider: () -> TextFieldValue,
    onNameInputChange: (TextFieldValue) -> Unit, // Изменено: принимает TextFieldValue
    onSurnameInputChange: (TextFieldValue) -> Unit, // Изменено: принимает TextFieldValue
    onNumberFromBankInputChange: (TextFieldValue) -> Unit,
    onCodeFromBankInputChange: (TextFieldValue) -> Unit, // Изменено: принимает TextFieldValue
) {
    val myTextFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent //необязательно
        // ... другие цвета ...
    )
    val myButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = colorResource(R.color.white_red_active)
    )
    val numberFromBank = numberFromBankProvider()
    val codeFromBank = codeFromBankProvider()
    val name = nameProvider()
    val surname = surnameProvider()
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = dimensionResource(R.dimen.large_padding))
        ) {
            Text(
                modifier = Modifier
                    .widthIn(min = 40.dp, max = 350.dp)
                    .padding(bottom = dimensionResource(R.dimen.large_padding)),
                text = stringResource(R.string.registration_for_bank_customers_header),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            )

            TextField(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                value = numberFromBank, // Изменено: доступ к тексту через numberFromBank.text
                onValueChange = { onNumberFromBankInputChange((it)) }, // Изменено: передача TextFieldValue
                enabled = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.number_of_customer_label),
                        color = colorResource(R.color.basic_light_gray),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next // Изменено: ImeAction.Next для перехода к следующему полю
                ),
                keyboardActions = KeyboardActions(onNext = { keyboardController?.hide() }),
                colors = myTextFieldColors
            )
            Spacer(modifier = Modifier.height(4.dp)) // Добавим немного пространства между TextField и supportingText
            Text(
                text = stringResource(id = R.string.number_of_customer_support_text),
                color = colorResource(id = R.color.basic_light_gray),
                fontSize = 12.sp

            )

            TextField(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.medium_padding)),
                shape = RoundedCornerShape(16.dp),
                value = numberFromBank, // Изменено: доступ к тексту через numberFromBank.text
                onValueChange = { onNumberFromBankInputChange((it)) }, // Изменено: передача TextFieldValue
                enabled = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.number_of_customer_label),
                        color = colorResource(R.color.basic_light_gray),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next // Изменено: ImeAction.Next для перехода к следующему полю
                ),
                keyboardActions = KeyboardActions(onNext = { keyboardController?.hide() }),
                colors = myTextFieldColors
            )
            Spacer(modifier = Modifier.height(4.dp)) // Добавим немного пространства между TextField и supportingText
            Text(
                text = stringResource(id = R.string.number_of_customer_support_text),
                color = colorResource(id = R.color.basic_light_gray),
                fontSize = 12.sp

            )
            TextField(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.medium_padding)),
                shape = RoundedCornerShape(16.dp),
                value = numberFromBank, // Изменено: доступ к тексту через numberFromBank.text
                onValueChange = { onNumberFromBankInputChange((it)) }, // Изменено: передача TextFieldValue
                enabled = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.number_of_customer_label),
                        color = colorResource(R.color.basic_light_gray),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next // Изменено: ImeAction.Next для перехода к следующему полю
                ),
                keyboardActions = KeyboardActions(onNext = { keyboardController?.hide() }),
                colors = myTextFieldColors
            )
            Spacer(modifier = Modifier.height(4.dp)) // Добавим немного пространства между TextField и supportingText
            Text(
                text = stringResource(id = R.string.number_of_customer_support_text),
                color = colorResource(id = R.color.basic_light_gray),
                fontSize = 12.sp

            )
            TextField(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.medium_padding)),
                shape = RoundedCornerShape(16.dp),
                value = numberFromBank, // Изменено: доступ к тексту через numberFromBank.text
                onValueChange = { onNumberFromBankInputChange((it)) }, // Изменено: передача TextFieldValue
                enabled = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.number_of_customer_label),
                        color = colorResource(R.color.basic_light_gray),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next // Изменено: ImeAction.Next для перехода к следующему полю
                ),
                keyboardActions = KeyboardActions(onNext = { keyboardController?.hide() }),
                colors = myTextFieldColors
            )
            Spacer(modifier = Modifier.height(4.dp)) // Добавим немного пространства между TextField и supportingText
            Text(
                text = stringResource(id = R.string.number_of_customer_support_text),
                color = colorResource(id = R.color.basic_light_gray),
                fontSize = 12.sp

            )

        }
        val annotatedString = buildAnnotatedString {
            append("Нажимая на кнопку продолжить,\nвы соглашаетесь с ")
            withStyle(
                SpanStyle(textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold)
            ) {
                append("условиями участия")
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)) {
            Text(
                annotatedString,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = colorResource(R.color.addition_light_gray)
            )
            FilledTonalButton(
                {},
                colors = myButtonColors,
                modifier = Modifier.fillMaxWidth(),
            ) { Text("Продолжить") }
        }
    }
}