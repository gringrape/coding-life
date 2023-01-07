package com.gringrape.board.services

import com.gringrape.board.domain.Post
import com.gringrape.board.domain.PostRepository
import com.gringrape.board.dtos.CreatePostDto
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreatePostService(val postRepository: PostRepository) {
    fun create(createPostDto: CreatePostDto) {
        val post = Post(
            author = createPostDto.author,
            title = createPostDto.title,
            content = createPostDto.content,
            createdAt = Clock.System.now().toLocalDateTime(TimeZone.UTC),
        )

        postRepository.save(post)
    }
}
