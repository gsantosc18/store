package com.picpay.store.application.usecase.product

import com.picpay.store.domain.Product

fun interface ListProductsUseCase {
    fun execute(): List<Product>
}