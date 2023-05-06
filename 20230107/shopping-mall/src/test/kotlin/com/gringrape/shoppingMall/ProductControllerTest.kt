package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.domain.Product
import com.gringrape.shoppingMall.exceptions.ProductNotFoundException
import com.gringrape.shoppingMall.service.FindProductService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import org.hamcrest.core.StringContains.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ProductController::class])
class ProductControllerTest : DescribeSpec() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var findProductService: FindProductService

    init {
        describe("GET /products") {
            beforeEach {
                every { findProductService.list() } returns listOf(Product.fake())
            }

            it("responds with list of products") {
                mockMvc.perform(get("/products"))
                    .andExpect(status().isOk)
                    .andExpect(content().string(containsString("[{\"id\"")))
            }
        }

        describe("GET /products/{id}") {
            val id = 1L

            context("when product exists") {
                beforeEach {
                    every { findProductService.findOne(id) } returns Product.fake()
                }

                it("responds with ok status") {
                    mockMvc.perform(get("/products/$id"))
                        .andExpect(status().isOk)
                }
            }

            context("when product not found") {
                beforeEach {
                    every { findProductService.findOne(id) } throws ProductNotFoundException(id)
                }

                it("responds with BAD REQUEST status") {
                    mockMvc.perform(get("/products/$id"))
                        .andExpect(status().isBadRequest)
                }
            }
        }
    }
}
