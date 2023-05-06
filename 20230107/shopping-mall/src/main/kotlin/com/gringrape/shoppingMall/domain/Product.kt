package com.gringrape.shoppingMall.domain

class Product(
    val id: Long,
    val name: String,
    val price: Long,
    val stockQuantity: Int
) {
    companion object {
        fun fake(): Product {
            return Product(
                id = 1L,
                name = "dummy",
                price = 100_000L,
                stockQuantity = 5
            )
        }
    }
}
