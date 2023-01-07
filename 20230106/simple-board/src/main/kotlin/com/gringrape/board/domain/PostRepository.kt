package com.gringrape.board.domain

interface PostRepository {
    fun save(post: Post)
    fun findAll(): List<Post>
    fun findById(id: Long): Post?
    fun remove(id: Long)
    fun existById(id: Long): Boolean
}
