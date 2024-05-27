package com.picpay.store.infra.database.persistence

import com.picpay.store.application.persitence.ProductPersistence
import com.picpay.store.domain.Product
import com.picpay.store.infra.database.entity.ProductEntity.Companion.from
import com.picpay.store.infra.database.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class ProductPersistenceImpl(
    private val productRepository: ProductRepository
): ProductPersistence {

    override fun save(product: Product) {
        from(product).also(productRepository::save)
    }

    override fun findAll(): List<Product> {
        return productRepository.findAll().map{ it.toDomain() }
    }

}