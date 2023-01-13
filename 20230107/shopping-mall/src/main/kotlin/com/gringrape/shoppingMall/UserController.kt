package com.gringrape.shoppingMall

import com.gringrape.shoppingMall.dtos.CreateUserDto
import com.gringrape.shoppingMall.dtos.CreateUserResponseDto
import com.gringrape.shoppingMall.service.CreateUserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(
    val createUserService: CreateUserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody source: CreateUserDto): CreateUserResponseDto {
        val user = createUserService.create(source)
        return CreateUserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

}
