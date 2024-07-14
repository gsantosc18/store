package com.github.gsantosc18.store.domain.entity

import com.github.gsantosc18.store.infra.database.entity.ProductEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.UuidGenerator
import java.sql.Types

@Entity
@Table(name = "category")
data class Category(
    @Id
    @UuidGenerator
    @JdbcTypeCode(value = Types.VARCHAR)
    val id: String?,
    val name: String?,
    @OneToMany(mappedBy = "category")
    val products: List<ProductEntity>
) {
    constructor(id: String) : this(
        id = id,
        name = null,
        products = emptyList()
    )
}