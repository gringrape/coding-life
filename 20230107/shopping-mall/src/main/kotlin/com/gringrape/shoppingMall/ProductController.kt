package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.domain.Product
import com.gringrape.shoppingMall.dtos.ProductDto
import com.gringrape.shoppingMall.dtos.ProductListDto
import com.gringrape.shoppingMall.exceptions.ProductNotFoundException
import com.gringrape.shoppingMall.service.FindProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    val findProductService: FindProductService
) {

    @GetMapping
    fun list(): ProductListDto {
        val products = findProductService.list()
        return ProductListDto(
            products.map { makeDto(it) }
        )
    }

    @GetMapping("{id}")
    fun detail(@PathVariable id: Long): ProductDto {
        val product = findProductService.findOne(id)
        return makeDto(product)
    }

    private fun makeDto(product: Product): ProductDto {
        return ProductDto(
            id = product.id,
            name = product.name,
            price = product.price
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleProductNotFound(exception: ProductNotFoundException): String {
        return "Product not found"
    }

}
