package com.gringrape.shoppingMall.domain

interface ProductRepository {

    fun findAll(): List<Product>
    fun findById(id: Long): Product?

}
