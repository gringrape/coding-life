package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.domain.User
import com.gringrape.shoppingMall.service.CreateUserService
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

@WebMvcTest(controllers = [UserController::class])
class UserControllerTest : DescribeSpec() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var createUserService: CreateUserService

    init {
        describe("POST /users") {
            val name = "Jin"
            val password = "PASS"
            val address = "서울시 강남구 삼성동"
            val email = "kingkong@kingkong.com"
            val phone = "010-1234-1234"

            beforeEach {
                every { createUserService.create(any()) } returns User.fake()
            }

            it("responds with created user") {
                mockMvc.perform(
                    post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"$name\",\"password\":\"$password\",\"address\":\"$address\",\"email\":\"$email\",\"phone\":\"$phone\"}")
                )
                    .andExpect(status().isCreated)
                    .andExpect(content().string(containsString("\"name\":")))
            }

            context("with blank information") {
                it("responds with bad request status") {
                    mockMvc.perform(
                        post("/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\":\"\",\"password\":\"$password\",\"address\":\"$address\",\"email\":\"$email\",\"phone\":\"$phone\"}")
                    )
                        .andExpect(status().isBadRequest)
                }
            }
        }
    }
}
