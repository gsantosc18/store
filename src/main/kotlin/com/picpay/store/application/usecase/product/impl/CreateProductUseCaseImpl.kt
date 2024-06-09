package com.picpay.store.application.usecase.product.impl

import com.picpay.store.application.usecase.product.CreateProductUseCase
import com.picpay.store.application.repository.ProductRepository
import com.picpay.store.domain.Product
import org.springframework.stereotype.Service

@Service
class CreateProductUseCaseImpl(
    private val productRepository: ProductRepository
): CreateProductUseCase {
    override fun execute(product: Product) {
        productRepository.save(product)
    }
}