package com.example.mileonair_test.ui.composable

import android.widget.ToggleButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mileonair_test.R

@Composable
internal fun ProfileScreen(
    surname: String = "Surname",
    name: String = "Name",
) {

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "$surname\n\n$name",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = R.drawable.edit_icon_v2),
                contentDescription = "edit_icon",
                tint = colorResource(R.color.basic_light_gray)
            )
        }
        Text(
            text = stringResource(R.string.number_plug),
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(R.color.basic_light_gray),
            modifier = Modifier.padding(
                vertical =
                dimensionResource(R.dimen.large_padding)
            )
        )

        Text(
            text = stringResource(R.string.my_purchases_header),
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(R.color.basic_light_gray),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(
                        R.dimen.medium_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {
            Icon(painter = painterResource(R.drawable.mileonair_logo), "mileonair_logo")
            Icon(painter = painterResource(R.drawable.arrow_right), "right_button")


        }
        Text(
            text = stringResource(R.string.settings_header),
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(R.color.basic_light_gray),
            modifier = Modifier.padding(
                top =
                dimensionResource(R.dimen.large_padding)
            )
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        R.dimen.medium_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.email_header),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.basic_light_gray),
                fontSize = 18.sp,
            )
            Column {
                Row {
                    Text(
                        text = stringResource(R.string.email_plug),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                    )
                    Icon(painter = painterResource(R.drawable.arrow_right), "right_button")
                }
                Text(
                    text = stringResource(R.string.need_to_be_approve_hint),
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 10.sp,
                    color = colorResource(R.color.white_red_inactive),
                )

            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        R.dimen.small_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.entry_by_biometry),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.basic_light_gray),
                fontSize = 18.sp,
            )
            CustomSwitch(true)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        R.dimen.small_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.change_code_header),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.basic_light_gray),
                fontSize = 20.sp,
            )
            Icon(painter = painterResource(R.drawable.arrow_right), "right_button")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        R.dimen.small_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.registration_for_bank_customer_header),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.basic_light_gray),
                fontSize = 18.sp,
            )
            Icon(painter = painterResource(R.drawable.arrow_right), "right_button")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        R.dimen.small_padding
                    )
                )
                .background(
                    color = colorResource(R.color.container_bacground_dark),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        R.dimen.large_padding
                    )
                )
        ) {

            Text(
                text = stringResource(R.string.language_header),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.basic_light_gray),
                fontSize = 18.sp,
            )
            Column {
                Row {
                    Text(
                        text = stringResource(R.string.language_plug),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                    )
                    Icon(painter = painterResource(R.drawable.arrow_right), "right_button")
                }

            }
        }


    }
}
