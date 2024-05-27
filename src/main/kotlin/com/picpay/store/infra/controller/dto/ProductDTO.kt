package com.picpay.store.infra.controller.dto

import com.picpay.store.domain.Product
import com.picpay.store.domain.ProductType
import java.math.BigDecimal

data class ProductDTO(
    val title: String,
    val description: String?,
    val amount: BigDecimal,
    val productType: ProductType
) {

    fun toDomain(): Product = Product(
        id = null,
        title = title,
        description = description,
        amount = amount,
        productType = productType
    )

}