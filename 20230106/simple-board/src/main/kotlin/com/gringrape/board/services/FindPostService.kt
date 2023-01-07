package com.gringrape.board.services

import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.domain.Post
import com.gringrape.board.domain.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FindPostService(
    val postRepository: PostRepository
) {
    fun list(): List<Post> {
        return postRepository.findAll()
    }

    fun findOne(id: Long): Post {
        return postRepository.findById(id) ?: throw PostNotFoundException(id)
    }
}
