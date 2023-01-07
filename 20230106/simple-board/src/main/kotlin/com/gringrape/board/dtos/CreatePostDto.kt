package com.gringrape.board.dtos

import jakarta.validation.constraints.NotBlank

data class CreatePostDto(
    @field:NotBlank val author: String,
    @field:NotBlank val title: String,
    @field:NotBlank val content: String,
)
