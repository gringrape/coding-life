package com.gringrape.board.services

import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.domain.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeletePostService(
    private val postRepository: PostRepository
) {
    fun delete(id: Long) {
        if (!postRepository.existById(id)) {
            throw PostNotFoundException(id)
        }
        postRepository.remove(id)
    }
}
