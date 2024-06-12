package com.gringrape.shoppingMall.dtos

import javax.validation.constraints.NotBlank

data class CreateUserDto(
    @field:NotBlank val name: String,
    @field:NotBlank val address: String,
    @field:NotBlank val email: String,
    @field:NotBlank val password: String,
    @field:NotBlank val phone: String
)
