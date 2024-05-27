package com.picpay.store.infra.controller

import com.picpay.store.application.CreateProductUseCase
import com.picpay.store.application.ListProductsUseCase
import com.picpay.store.infra.controller.dto.ProductDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val listProductsUseCase: ListProductsUseCase
) {

    @PostMapping("/product")
    fun createNew(@RequestBody productDTO: ProductDTO): ResponseEntity<*> {
        createProductUseCase.execute(productDTO.toDomain())
        return ResponseEntity.status(HttpStatus.CREATED).build<Any>()
    }

    @GetMapping("/product")
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity.ok(listProductsUseCase.execute())
    }

}