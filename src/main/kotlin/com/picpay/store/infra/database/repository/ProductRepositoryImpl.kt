package com.picpay.store.infra.database.repository

import com.picpay.store.application.repository.ProductRepository
import com.picpay.store.domain.Product
import com.picpay.store.infra.database.entity.ProductEntity
import com.picpay.store.infra.metrics.CreateProductMeter
import com.picpay.store.infra.metrics.ListProductMeter
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
