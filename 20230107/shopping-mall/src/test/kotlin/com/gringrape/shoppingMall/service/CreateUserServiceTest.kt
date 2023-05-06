package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.User
import com.gringrape.shoppingMall.domain.UserRepository
import com.gringrape.shoppingMall.dtos.CreateUserDto
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.verify

class CreateUserServiceTest : DescribeSpec({

    lateinit var createUserService: CreateUserService
    lateinit var userRepository: UserRepository

    beforeEach {
        userRepository = mockk()
        createUserService = CreateUserService(userRepository)
    }

    describe("create") {
        val source = CreateUserDto(
            name = "Jin",
            address = "서울시 강남구 삼성동",
            password = "PASS",
            email = "kingkong@kingkong.com",
            phone = "010-1234-1234"
        )

        val user = User.fake()

        beforeEach {
            mockkObject(User.Companion)
            every { User.create(any()) } returns user
            
            every { userRepository.save(any()) } returns Unit
        }

        it("creates user") {
            createUserService.create(source)
            verify { userRepository.save(user) }
        }
    }

})
