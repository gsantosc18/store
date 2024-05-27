package com.picpay.store.application

import com.picpay.store.domain.Product

fun interface ListProductsUseCase {
    fun execute(): List<Product>
}