package com.github.gsantosc18.store.application.usecase.product

import com.github.gsantosc18.store.domain.entity.Product

fun interface CreateProductUseCase {
    fun handle(product: Product)
}