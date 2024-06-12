package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.*
import com.gringrape.shoppingMall.dtos.CreateOrderDto
import com.gringrape.shoppingMall.dtos.OrderItemDto
import com.gringrape.shoppingMall.exceptions.NotEnoughStockException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify


class OrderServiceTest : DescribeSpec({

    lateinit var orderRepository: OrderRepository
    lateinit var orderService: OrderService
    lateinit var userRepository: UserRepository
    lateinit var productRepository: ProductRepository

    beforeEach {
        userRepository = mockk()
        productRepository = mockk()
        orderRepository = mockk()

        orderService = OrderService(
            orderRepository = orderRepository,
            userRepository = userRepository,
            productRepository = productRepository
        )
    }

    describe("create") {
        val productId = 2L
        val quantity = 3

        val source = CreateOrderDto(
            userId = 1L,
            items = listOf(
                OrderItemDto(
                    productId = productId,
                    quantity = quantity
                )
            )
        )

        val user = mockk<User>()
        val product = Product.fake()
        val order = mockk<Order>()

        beforeEach {
            every { userRepository.findById(source.userId) } returns user
            every { productRepository.findById(productId) } returns product
            every { orderRepository.save(any()) } returns order
        }

        it("creates order") {
            orderService.order(source) shouldBe order
            verify { userRepository.findById(source.userId) }
            verify { productRepository.findById(source.items[0].productId) }
        }

        context("with not enough stock") {
            val item = source.items[0]

            beforeEach {
                every {
                    productRepository.findById(item.productId)
                } returns Product(stockQuantity = 0, id = 100L, name = "ANY", price = 1000)
            }

            it("throws exception") {
                shouldThrow<NotEnoughStockException> {
                    orderService.order(source)
                }
            }
        }
    }

})
