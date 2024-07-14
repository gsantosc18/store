package com.github.gsantosc18.store.infra.config

import com.github.gsantosc18.store.application.service.ProductService
import com.github.gsantosc18.store.application.usecase.product.CreateProductUseCase
import com.github.gsantosc18.store.application.usecase.product.ListProductsUseCase
import com.github.gsantosc18.store.application.usecase.product.impl.CreateProductUseCaseImpl
import com.github.gsantosc18.store.application.usecase.product.impl.ListProductsUseCaseImpl
import com.github.gsantosc18.store.infra.database.repository.ProductRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductConfig {
    @Bean
    fun createProductUseCase(
        repository: ProductRepositoryImpl
    ) = CreateProductUseCaseImpl(repository = repository)

    @Bean
    fun listProductUseCase(
        repository: ProductRepositoryImpl
    ) = ListProductsUseCaseImpl(repository = repository)

    @Bean
    fun productService(
        createProductUseCase: CreateProductUseCase,
        listProductsUseCase: ListProductsUseCase
    ) = ProductService(
        createProductUseCase = createProductUseCase,
        listProductsUseCase = listProductsUseCase
    )
}