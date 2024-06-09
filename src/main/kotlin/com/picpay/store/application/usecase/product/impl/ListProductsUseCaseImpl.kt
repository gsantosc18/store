package com.picpay.store.application.usecase.product.impl

import com.picpay.store.application.usecase.product.ListProductsUseCase
import com.picpay.store.application.repository.ProductRepository
import com.picpay.store.domain.Product
import org.springframework.stereotype.Service

@Service
class ListProductsUseCaseImpl(
    private val productRepository: ProductRepository
): ListProductsUseCase {
    override fun execute(): List<Product> {
        return productRepository.findAll()
    }
}