package com.gringrape.codingtest

import io.kotest.core.spec.style.DescribeSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class AnswerControllerTests : DescribeSpec() {
    @Autowired
    lateinit var mockMvc: MockMvc

    init {
        describe("POST /answers") {
            it("responds with CREATED status") {
                mockMvc.perform(post("/answers"))
                    .andExpect(status().isCreated)
            }
        }
    }
}
