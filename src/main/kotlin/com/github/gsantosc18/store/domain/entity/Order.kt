package com.github.gsantosc18.store.domain.entity

import java.time.LocalDateTime

data class Order(
    val id: String?,
    val items: List<OrderItem>,
    val customerId: String,
    val createdAt: LocalDateTime
)
