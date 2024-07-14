package com.github.gsantosc18.store.presentation.api.dto

import com.github.gsantosc18.store.domain.entity.Product
import java.math.BigDecimal

data class ProductDTO(
    val title: String,
    val description: String,
    val amount: BigDecimal,
    val categories: List<CategoryDTO> = emptyList()
) {

    fun toDomain(): Product = Product(
        id = null,
        title = title,
        description = description,
        amount = amount,
        categoryIds = categories.map(CategoryDTO::name),
        inventoryId = null
    )

}