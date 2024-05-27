package com.picpay.store.application.impl

import com.picpay.store.application.ListProductsUseCase
import com.picpay.store.application.persitence.ProductPersistence
import com.picpay.store.domain.Product
import org.springframework.stereotype.Service

@Service
class ListProductsUseCaseImpl(
    private val productPersistence: ProductPersistence
): ListProductsUseCase {
    override fun execute(): List<Product> {
        return productPersistence.findAll()
    }
}