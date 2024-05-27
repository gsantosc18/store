package com.picpay.store.application.impl

import com.picpay.store.application.CreateProductUseCase
import com.picpay.store.application.persitence.ProductPersistence
import com.picpay.store.domain.Product
import org.springframework.stereotype.Service

@Service
class CreateProductUseCaseImpl(
    private val productPersistence: ProductPersistence
): CreateProductUseCase {
    override fun execute(product: Product) {
        productPersistence.save(product)
    }
}