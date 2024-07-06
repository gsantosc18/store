package com.github.gsantosc18.store.infra.database.repository

import com.github.gsantosc18.store.application.repository.ProductRepository
import com.github.gsantosc18.store.domain.Product
import com.github.gsantosc18.store.infra.database.entity.ProductEntity
import com.github.gsantosc18.store.infra.metrics.CreateProductMeter
import com.github.gsantosc18.store.infra.metrics.ListProductMeter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import java.util.*


interface JpaProductRepository: JpaRepository<ProductEntity, UUID>

@Component
class  ProductRepositoryImpl(
    private val productRepository: JpaProductRepository,
    private val listProductMeter: ListProductMeter,
    private val createProductMeter: CreateProductMeter
): ProductRepository {
    override fun save(product: Product) {
        ProductEntity.from(product).also{ p ->
            createProductMeter.timer()
                .recordCallable {
                    productRepository.save(p)
                }
        }
    }

    override fun findAll(): List<Product> =
        listProductMeter.timer()
            .record(productRepository::findAll)
            ?.map{ it.toDomain() } ?: emptyList()

}
