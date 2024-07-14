package com.github.gsantosc18.store.application.service

import com.github.gsantosc18.store.application.usecase.product.CreateProductUseCase
import com.github.gsantosc18.store.application.usecase.product.ListProductsUseCase
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Test

class ProductServiceTest {
    private val createProductUseCase: CreateProductUseCase = mockk(relaxed = true)
    private val listProductUseCase: ListProductsUseCase = mockk(relaxed = true)

    private val productService = ProductService(
        createProductUseCase = createProductUseCase,
        listProductsUseCase = listProductUseCase
    )

    @Test
    fun `Must create new product`() {
        every { createProductUseCase.handle(any()) } just runs

        productService.create(mockk(relaxed = true))

        verify(exactly = 1) { createProductUseCase.handle(any()) }
    }

    @Test
    fun `Must list products`() {
        every { listProductUseCase.handle() } returns listOf(mockk(relaxed = true))

        val products = productService.listAll()

        verify(exactly = 1) { listProductUseCase.handle() }
        assert(products.size == 1)
    }
}