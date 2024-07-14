package com.github.gsantosc18.store.application.service

import com.github.gsantosc18.store.application.usecase.product.CreateProductUseCase
import com.github.gsantosc18.store.application.usecase.product.ListProductsUseCase
import com.github.gsantosc18.store.domain.entity.Product

class ProductService(
    private val createProductUseCase: CreateProductUseCase,
    private val listProductsUseCase: ListProductsUseCase
) {
    fun create(product: Product) {
        createProductUseCase.handle(product)
    }

    fun listAll() = listProductsUseCase.handle()
}