package com.example.mileonair_test.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mileonair_test.R


@Composable
internal fun BaseLayout(
    modifier: Modifier,
    onBack: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .then(modifier)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        OutlinedButton(
            modifier = Modifier.align(Alignment.Start),
            onClick = onBack,
            border = BorderStroke(2.dp, colorResource(R.color.container_bacground_dark)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
            ),
contentPadding = PaddingValues(12.dp)

        ) {
            Row() {
                Icon(painter = painterResource(R.drawable.arrow_back), "back_button")
                Text("Назад", modifier = Modifier.align(Alignment.CenterVertically))
            }
        }

        content()
    }
}