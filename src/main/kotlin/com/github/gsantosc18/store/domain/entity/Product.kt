package com.github.gsantosc18.store.domain.entity

import java.math.BigDecimal

data class Product(
    val id: String?,
    val title: String,
    val amount: BigDecimal,
    val description: String,
    val categoryIds: List<String>,
    val inventoryId: String?
)
