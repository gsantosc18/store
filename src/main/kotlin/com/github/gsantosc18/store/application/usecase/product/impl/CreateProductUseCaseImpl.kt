package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.application.usecase.product.CreateProductUseCase
import com.github.gsantosc18.store.domain.entity.Product
import com.github.gsantosc18.store.domain.repository.CreateProductRepository

class CreateProductUseCaseImpl(
    private val repository: CreateProductRepository
): CreateProductUseCase {
    override fun handle(product: Product) {
        repository.insert(product)
    }
}