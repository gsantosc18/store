package com.picpay.store.application.persitence

import com.picpay.store.domain.Product

interface ProductPersistence {
    fun save(product: Product)
    fun findAll(): List<Product>
}