package com.example.mileonair_test.ui.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mileonair_test.presentation.PurchasesViewModel

@Composable
fun PurchasesScreen(viewModel: PurchasesViewModel = hiltViewModel()) {
    val purchaseGroups = viewModel.purchaseGroups.collectAsState().value

    LazyColumn {
        purchaseGroups.forEach { group ->
            item {
                Text(text = group.date, style = MaterialTheme.typography.headlineMedium)
            }
            group.items.forEach { item ->
                item { Text(text = item) }
            }
        }
    }
}