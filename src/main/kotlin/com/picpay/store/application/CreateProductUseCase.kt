package com.picpay.store.application

import com.picpay.store.domain.Product

fun interface CreateProductUseCase {
    fun execute(product: Product)
}