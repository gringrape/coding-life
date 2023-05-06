package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.domain.Order
import com.gringrape.shoppingMall.service.OrderService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import org.hamcrest.core.StringContains.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [OrderController::class])
class OrderControllerTest : DescribeSpec() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var orderService: OrderService

    init {
        describe("POST /orders") {
            val userId = 1L
            val productId = 1L
            val quantity = 3

            beforeEach {
                every { orderService.order(any()) } returns Order.fake()
            }

            it("responds with created order") {
                mockMvc.perform(
                    post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":${userId},\"items\":[{\"productId\":$productId,\"quantity\":$quantity}]}")
                )
                    .andExpect(status().isCreated)
                    .andExpect(content().string(containsString("\"userId\":${userId}")))
            }
        }
    }

}
