package com.example.mileonair_test.domain.api

import com.example.mileonair_test.domain.model.PurchaseGroup
import com.example.mileonair_test.domain.model.PurchaseItem

interface PurchaseRepository {
    suspend fun getPurchaseData(): List<PurchaseItem>
    fun transformData(purchaseList: List<PurchaseItem>): List<PurchaseGroup>
}