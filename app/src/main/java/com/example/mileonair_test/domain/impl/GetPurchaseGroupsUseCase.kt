package com.example.mileonair_test.domain.impl

import com.example.mileonair_test.domain.api.PurchaseRepository
import com.example.mileonair_test.domain.model.PurchaseGroup
import javax.inject.Inject

class GetPurchaseGroupsUseCase @Inject constructor(private val repository: PurchaseRepository) {
    suspend operator fun invoke(): List<PurchaseGroup> {
        val purchaseItems = repository.getPurchaseData()
        return repository.transformData(purchaseItems)
    }
}