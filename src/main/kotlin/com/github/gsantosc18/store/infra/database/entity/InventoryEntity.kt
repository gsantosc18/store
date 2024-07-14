package com.github.gsantosc18.store.infra.database.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.UuidGenerator
import java.sql.Types

@Entity
@Table(name = "inventory")
data class InventoryEntity(
    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    val id: String?,
    val amount: Long,
    @OneToOne(mappedBy = "inventory")
    val product: ProductEntity
)