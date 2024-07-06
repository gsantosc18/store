package com.github.gsantosc18.store.application.repository

import com.github.gsantosc18.store.domain.Product

interface ProductRepository {
    fun save(product: Product)
    fun findAll(): List<Product>
}