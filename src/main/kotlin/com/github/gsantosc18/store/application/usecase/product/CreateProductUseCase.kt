package com.github.gsantosc18.store.application.usecase.product

import com.github.gsantosc18.store.domain.Product

fun interface CreateProductUseCase {
    fun execute(product: Product)
}