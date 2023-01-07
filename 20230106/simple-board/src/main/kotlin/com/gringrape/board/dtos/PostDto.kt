package com.gringrape.board.dtos

data class PostDto(
    val id: Long,
    val author: String,
    val title: String,
    val content: String,
    val created: String,
)
