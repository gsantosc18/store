package com.github.gsantosc18.store.application.usecase.product.impl

import com.github.gsantosc18.store.domain.repository.ListProductRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class ListProductsUseCaseImplTest {
    private val repository: ListProductRepository = mockk(relaxed = true)
    private val listProductsUseCase = ListProductsUseCaseImpl(repository = repository)

    @Test
    fun `Must list products`() {
        every { repository.findAll() } returns listOf(mockk(), mockk())

        val products = listProductsUseCase.handle()

        verify { repository.findAll() }
        assert(products.size == 2)
    }
}