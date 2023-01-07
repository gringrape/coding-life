package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.domain.Product
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

@WebMvcTest
class ProductControllerTest : DescribeSpec() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var findProductService: FindProductService

    init {
        describe("GET /posts") {
            beforeEach {
                every { findProductService.list() } returns listOf(Product(id = 1L))
            }

            it("responds with list of products") {
                mockMvc.perform(get("/posts"))
                    .andExpect(status().isOk)
                    .andExpect(content().string(containsString("[{\"id\"")))
            }
        }
    }
}
