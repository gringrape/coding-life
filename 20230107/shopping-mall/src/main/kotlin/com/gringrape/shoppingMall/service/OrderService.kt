package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.*
import com.gringrape.shoppingMall.dtos.CreateOrderDto
import com.gringrape.shoppingMall.exceptions.ProductNotFoundException
import com.gringrape.shoppingMall.exceptions.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    val orderRepository: OrderRepository,
    val userRepository: UserRepository,
    val productRepository: ProductRepository
) {

    fun order(source: CreateOrderDto): Order {
        val user = userRepository.findById(source.userId)
            ?: throw UserNotFoundException(source.userId)

        val orderItems = source.items.map {
            val product: Product = productRepository.findById(it.productId)
                ?: throw ProductNotFoundException(it.productId)
            OrderItem(
                product = product,
                count = it.quantity
            )
        }

        val order = Order.create(user, orderItems)

        return orderRepository.save(order)
    }

}
