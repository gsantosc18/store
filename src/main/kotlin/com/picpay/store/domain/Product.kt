package com.picpay.store.domain

import java.math.BigDecimal
import java.util.UUID

data class Product(
    val id: UUID?,
    val title: String?,
    val amount: BigDecimal?,
    val description: String?,
    val productType: ProductType?
)
