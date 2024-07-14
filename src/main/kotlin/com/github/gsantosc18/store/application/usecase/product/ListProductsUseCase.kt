package com.github.gsantosc18.store.application.usecase.product

import com.github.gsantosc18.store.domain.entity.Product

fun interface ListProductsUseCase {
    fun handle(): List<Product>
}