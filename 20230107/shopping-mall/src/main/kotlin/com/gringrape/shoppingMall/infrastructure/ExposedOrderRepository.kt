package com.gringrape.shoppingMall.infrastructure

import com.gringrape.shoppingMall.domain.Order
import com.gringrape.shoppingMall.domain.OrderRepository
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.insert
import org.springframework.stereotype.Repository

@Repository
class ExposedOrderRepository : OrderRepository {
    override fun save(order: Order): Order {
        // 1. order 에 아이디 부여하기
        //   - 테이블 구조를 생각해야 함. => Orders 테이블 부터 설계 => 결국 구현 이전에 설계가 대부분 결정되어야 한다는 논리.
        // 2. order items 에 아이디 부여하기
        // 추가고려 - order
        val id = Orders.insert {
            it[customerId] = order.customerId
            it[date] = order.date
        } get Orders.id

        order.register(id)

        OrderItems.batchInsert(order.items) {
            this[OrderItems.count] = it.count
            this[OrderItems.orderId] = id
            this[OrderItems.productId] = it.productId
        }

        return order
    }
}
