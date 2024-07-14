package com.github.gsantosc18.store.domain.entity

data class Address(
    val id: String,
    val cep: String,
    val city: String,
    val state: String,
    val neighborhood: String,
    val street: String,
    val number: String,
    val complement: String
)
