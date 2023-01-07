package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.dtos.ProductDto
import com.gringrape.shoppingMall.dtos.ProductListDto
import com.gringrape.shoppingMall.service.FindProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class ProductController(
    val findProductService: FindProductService
) {

    @GetMapping
    fun list(): ProductListDto {
        val products = findProductService.list()
        return ProductListDto(
            products.map {
                ProductDto(it.id)
            }
        )
    }
    
}
