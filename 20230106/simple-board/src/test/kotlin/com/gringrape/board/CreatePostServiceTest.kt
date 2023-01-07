package com.gringrape.board

import com.gringrape.board.domain.PostRepository
import com.gringrape.board.dtos.CreatePostDto
import com.gringrape.board.services.CreatePostService
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk


class CreatePostServiceTest : DescribeSpec({
    lateinit var createPostService: CreatePostService
    lateinit var postRepository: PostRepository

    beforeEach {
        postRepository = mockk()
        createPostService = CreatePostService(postRepository)
    }

    describe("create") {
        val createPostDto = CreatePostDto(
            author = "Hyunee",
            title = "밥이 맛이 없다",
            content = "그래서?",
        )

        beforeEach {
            every { postRepository.save(any()) } returns Unit
        }

        it("returns without crash") {
            createPostService.create(createPostDto)
        }
    }
})