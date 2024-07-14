package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.domain.entity.Product
import com.github.gsantosc18.store.domain.repository.CreateProductRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class CreateProductUseCaseImplTest {
    private val repository: CreateProductRepository = mockk(relaxed = true)
    private val createProductUseCase = CreateProductUseCaseImpl(repository = repository)

    @Test
    fun `Must create product`() {
        every { repository.insert(any()) } returns mockk()

        createProductUseCase.handle(product = mockk<Product>())

        verify(exactly = 1) { repository.insert(any()) }
    }
}