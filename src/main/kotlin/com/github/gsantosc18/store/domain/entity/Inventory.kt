package com.github.gsantosc18.store.domain.entity

data class Inventory(
    private val id: String?,
    private val amount: Long
) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Inventory amount must not be negative")
        }
    }
}
