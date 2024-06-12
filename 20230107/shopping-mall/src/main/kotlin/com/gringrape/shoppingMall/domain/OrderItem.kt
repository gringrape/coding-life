package com.gringrape.shoppingMall.domain

class OrderItem(
    id: Long = INITIAL_ID,
    orderId: Long = INITIAL_ID,
    val product: Product,
    val count: Int
) {

    var id = id
    val orderId = orderId

    val productId: Long
        get() = product.id

    fun checkStock(): Boolean {
        return count <= product.stockQuantity
    }
    
    companion object {
        fun fake(): OrderItem {
            return OrderItem(
                id = 1L,
                orderId = 1L,
                product = Product.fake(),
                count = 1
            )
        }
    }
}
