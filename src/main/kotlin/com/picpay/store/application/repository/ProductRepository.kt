package com.picpay.store.application.repository

import com.picpay.store.domain.Product

interface ProductRepository {
    fun save(product: Product)
    fun findAll(): List<Product>
}