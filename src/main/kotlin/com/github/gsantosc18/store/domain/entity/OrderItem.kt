package com.github.gsantosc18.store.domain.entity

import java.math.BigDecimal

data class OrderItem(
    val id: String?,
    val productId: String,
    val quantity: Int,
    val price: BigDecimal
)