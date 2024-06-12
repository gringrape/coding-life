package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.Product
import com.gringrape.shoppingMall.domain.ProductRepository
import com.gringrape.shoppingMall.exceptions.ProductNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FindProductService(
    val productRepository: ProductRepository
) {

    fun list(): List<Product> {
        return productRepository.findAll()
    }

    fun findOne(id: Long): Product {
        return productRepository.findById(id)
            ?: throw ProductNotFoundException(id)
    }

}
