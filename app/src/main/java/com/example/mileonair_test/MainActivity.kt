package com.example.mileonair_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mileonair_test.ui.composable.BaseLayout
import com.example.mileonair_test.ui.composable.ProfileScreen
import com.example.mileonair_test.ui.theme.Mileonair_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
                        ProfileScreen()
                    }

                }
            }
        }
    }
}


