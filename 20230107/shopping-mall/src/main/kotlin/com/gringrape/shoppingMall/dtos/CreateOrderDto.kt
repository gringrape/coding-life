package com.gringrape.shoppingMall.dtos

data class CreateOrderDto(
    val userId: Long,
    val items: List<OrderItemDto>
)
