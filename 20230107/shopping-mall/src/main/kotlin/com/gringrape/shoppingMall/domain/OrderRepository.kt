package com.gringrape.shoppingMall.domain

interface OrderRepository {

    fun save(order: Order): Order

}
