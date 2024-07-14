package com.github.gsantosc18.store.domain.entity

data class Customer(
    val id: String?,
    val name: String,
    val email: String,
    val contact: List<Contact>,
    val address: Address
)