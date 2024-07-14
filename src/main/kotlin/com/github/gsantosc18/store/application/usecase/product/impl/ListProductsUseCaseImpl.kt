package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.application.usecase.product.ListProductsUseCase
import com.github.gsantosc18.store.domain.entity.Product
import com.github.gsantosc18.store.domain.repository.ListProductRepository

class ListProductsUseCaseImpl(
    private val repository: ListProductRepository
): ListProductsUseCase {
    override fun handle(): List<Product> {
        return repository.findAll()
    }
}