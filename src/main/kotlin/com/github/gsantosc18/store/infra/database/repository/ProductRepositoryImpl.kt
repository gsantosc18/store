package com.github.gsantosc18.store.infra.database.repository

import com.github.gsantosc18.store.domain.entity.Product
import com.github.gsantosc18.store.domain.repository.CreateProductRepository
import com.github.gsantosc18.store.domain.repository.ListProductRepository
import com.github.gsantosc18.store.infra.database.entity.ProductEntity
import com.github.gsantosc18.store.infra.metrics.CreateProductMeter
import com.github.gsantosc18.store.infra.metrics.ListProductMeter
import com.github.gsantosc18.store.shared.record
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import java.util.*


interface JpaProductRepository: JpaRepository<ProductEntity, UUID>

@Component
class  ProductRepositoryImpl(
    private val productRepository: JpaProductRepository,
    private val listProductMeter: ListProductMeter,
    private val createProductMeter: CreateProductMeter
): CreateProductRepository, ListProductRepository {
    override fun insert(product: Product): Product =
        ProductEntity.from(product)
            .record(
                createProductMeter.timer(),
                productRepository::save
            )
            .toDomain()

    override fun findAll(): List<Product> =
        listProductMeter.timer()
            .record(productRepository::findAll)
            ?.map(ProductEntity::toDomain)
            ?: emptyList()
}
