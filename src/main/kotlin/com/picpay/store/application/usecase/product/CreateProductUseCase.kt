package com.picpay.store.application.usecase.product

import com.picpay.store.domain.Product

fun interface CreateProductUseCase {
    fun execute(product: Product)
}