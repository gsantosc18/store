package com.github.gsantosc18.store.presentation.api.controller

import com.github.gsantosc18.store.application.service.ProductService
import com.github.gsantosc18.store.presentation.api.dto.ProductDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createNew(@RequestBody productDTO: ProductDTO): ResponseEntity<*> {
        productService.create(productDTO.toDomain())
        return ResponseEntity.status(HttpStatus.CREATED).build<Any>()
    }

    @GetMapping
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity.ok(productService.listAll())
    }

}