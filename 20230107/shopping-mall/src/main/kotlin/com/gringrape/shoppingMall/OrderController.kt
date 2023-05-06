package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.dtos.CreateOrderDto
import com.gringrape.shoppingMall.dtos.OrderDto
import com.gringrape.shoppingMall.dtos.OrderItemDto
import com.gringrape.shoppingMall.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    val orderService: OrderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody source: CreateOrderDto): OrderDto {
        val order = orderService.order(source)
        return OrderDto(
            id = order.id,
            userId = order.customer.id,
            items = order.items.map {
                OrderItemDto(
                    productId = it.id,
                    quantity = it.count
                )
            }
        )
    }

}
