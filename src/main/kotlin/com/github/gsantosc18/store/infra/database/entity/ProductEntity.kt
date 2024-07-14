package com.github.gsantosc18.store.infra.database.entity

import com.github.gsantosc18.store.domain.entity.Category
import com.github.gsantosc18.store.domain.entity.Product
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.UuidGenerator
import java.math.BigDecimal
import java.sql.Types
import java.util.*

@Entity
@Table(name = "product")
data class ProductEntity(
    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    val id: UUID? = null,
    val title: String,
    val description: String,
    val amount: BigDecimal,
    @ManyToMany
    val category: List<Category> = emptyList(),
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    val inventory: InventoryEntity?
) {

    constructor(): this(
        id = null,
        title = "",
        description = "",
        amount = BigDecimal.ZERO,
        category = emptyList(),
        inventory = null
    )

    fun toDomain(): Product = Product(
        id = id.toString(),
        title = title,
        description = description,
        amount = amount,
        categoryIds = category.mapNotNull(Category::id),
        inventoryId = inventory?.let(InventoryEntity::id)
    )

    companion object {
        fun from(product: Product): ProductEntity = ProductEntity(
            id = null,
            title = product.title,
            description = product.description,
            amount = product.amount,
            category = product.categoryIds.map(::Category),
            inventory = null
        )
    }
}
