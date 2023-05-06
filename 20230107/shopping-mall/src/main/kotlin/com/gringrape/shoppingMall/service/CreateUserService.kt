package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.User
import com.gringrape.shoppingMall.domain.UserRepository
import com.gringrape.shoppingMall.dtos.CreateUserDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateUserService(
    val userRepository: UserRepository
) {

    fun create(source: CreateUserDto): User {
        val user = User.create(source)

        userRepository.save(user)

        return user
    }

}
