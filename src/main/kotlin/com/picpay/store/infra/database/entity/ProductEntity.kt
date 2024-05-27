package com.picpay.store.infra.database.entity

import com.picpay.store.domain.Product
import com.picpay.store.domain.ProductType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.UuidGenerator
import java.math.BigDecimal
import java.sql.Types
import java.util.UUID

@Entity
@Table(name = "product")
data class ProductEntity(
    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
    val amount: BigDecimal? = null,
    @Enumerated(EnumType.STRING)
    val productType: ProductType? = null
) {

    fun toDomain(): Product = Product(
        id = id,
        title = title,
        description = description,
        amount = amount,
        productType = productType
    )

    companion object {
        fun from(product: Product): ProductEntity = ProductEntity(
            id = null,
            title = product.title,
            description = product.description,
            amount = product.amount,
            productType = product.productType
        )
    }
}
