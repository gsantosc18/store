package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.application.usecase.product.CreateProductUseCase
import com.github.gsantosc18.store.application.repository.ProductRepository
import com.github.gsantosc18.store.domain.Product
import org.springframework.stereotype.Service

@Service
class CreateProductUseCaseImpl(
    private val productRepository: ProductRepository
): CreateProductUseCase {
    override fun execute(product: Product) {
        productRepository.save(product)
    }
}