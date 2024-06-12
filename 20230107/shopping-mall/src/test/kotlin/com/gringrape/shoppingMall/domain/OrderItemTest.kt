package com.gringrape.shoppingMall.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OrderItemTest : DescribeSpec({
    describe("checkStock") {
        it("returns whether stock quantity is enough") {
            val stockQuantity = 100
            val count = 5

            val orderItem = OrderItem(
                count = count,
                product = Product(stockQuantity = stockQuantity, id = 1L, name = "ANY", price = 100)
            )
            orderItem.checkStock() shouldBe true
        }
    }
})
