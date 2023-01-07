package com.gringrape.board.services

import com.gringrape.board.domain.PostRepository
import com.gringrape.board.dtos.UpdatePostDto
import com.gringrape.board.exceptions.PostNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdatePostService(
    val postRepository: PostRepository
) {
    fun update(id: Long, source: UpdatePostDto) {
        val post = postRepository.findById(id)
            ?: throw PostNotFoundException(id)
        post.updateContent(source.content)
        postRepository.save(post)
    }
}
