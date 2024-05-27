package com.picpay.store.infra.database.repository

import com.picpay.store.infra.database.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository: JpaRepository<ProductEntity, UUID>