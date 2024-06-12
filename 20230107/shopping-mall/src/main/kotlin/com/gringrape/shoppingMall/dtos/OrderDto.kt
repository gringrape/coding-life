package com.gringrape.shoppingMall.dtos

data class OrderDto(
    val id: Long,
    val userId: Long,
    val items: List<OrderItemDto>,
)
