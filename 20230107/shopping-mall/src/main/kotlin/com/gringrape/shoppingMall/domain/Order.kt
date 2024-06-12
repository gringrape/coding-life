package com.gringrape.shoppingMall.domain

import com.gringrape.shoppingMall.exceptions.NotEnoughStockException
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// TODO 초기 아이디로 생성되지 않도록 하기
class Order(
    id: Long = INITIAL_ID,
    val customer: User,
    val items: List<OrderItem>,
    val date: LocalDateTime,
) {
    var id: Long = id
        private set

    val customerId: Long
        get() = this.customer.id

    fun register(id: Long) {
        this.id = id
    }

    fun setItemIds(orderItemIds: List<Long>) {
        orderItemIds.forEach {

        }
    }

    companion object {
        fun fake(): Order {
            return Order(
                id = 1L,
                customer = User.fake(),
                items = listOf(OrderItem.fake()),
                date = Clock.System.now().toLocalDateTime(TimeZone.UTC)
            )
        }

        fun create(user: User, orderItems: List<OrderItem>): Order {
            if (!checkEnoughStock(orderItems)) {
                throw NotEnoughStockException()
            }
            return Order(
                customer = user,
                items = orderItems,
                date = Clock.System.now().toLocalDateTime(TimeZone.UTC)
            )
        }

        private fun checkEnoughStock(orderItems: List<OrderItem>): Boolean {
            return orderItems.any { it.checkStock() }
        }
    }
}
