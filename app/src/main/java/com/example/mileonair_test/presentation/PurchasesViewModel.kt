package com.example.mileonair_test.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mileonair_test.domain.impl.GetPurchaseGroupsUseCase
import com.example.mileonair_test.domain.model.PurchaseGroup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PurchasesViewModel @Inject constructor(private val getPurchaseGroupsUseCase: GetPurchaseGroupsUseCase) :
    ViewModel() {
    private val _purchaseGroups = MutableStateFlow<List<PurchaseGroup>>(emptyList())
    val purchaseGroups: StateFlow<List<PurchaseGroup>> = _purchaseGroups.asStateFlow()

    init {
        viewModelScope.launch {
            val purchaseGroups = getPurchaseGroupsUseCase()
            _purchaseGroups.value = purchaseGroups
        }
    }
}