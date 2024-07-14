package com.github.gsantosc18.store.domain.repository

import com.github.gsantosc18.store.domain.entity.Product

interface CreateProductRepository {
    fun insert(product: Product): Product
}