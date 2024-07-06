package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.application.usecase.product.ListProductsUseCase
import com.github.gsantosc18.store.application.repository.ProductRepository
import com.github.gsantosc18.store.domain.Product
import org.springframework.stereotype.Service

@Service
class ListProductsUseCaseImpl(
    private val productRepository: ProductRepository
): ListProductsUseCase {
    override fun execute(): List<Product> {
        return productRepository.findAll()
    }
}