package com.gringrape.board.services

import com.gringrape.board.domain.Post
import com.gringrape.board.domain.PostRepository
import com.gringrape.board.dtos.UpdatePostDto
import com.gringrape.board.exceptions.PostNotFoundException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk

class UpdatePostServiceTest : DescribeSpec({
    lateinit var updatePostService: UpdatePostService
    lateinit var postRepository: PostRepository

    beforeEach {
        postRepository = mockk()
        updatePostService = UpdatePostService(postRepository)
    }

    describe("update") {
        val id = 1L
        val updatePostDto = UpdatePostDto(content = "그래서?")

        context("when post found") {
            beforeEach {
                every { postRepository.findById(id) } returns Post.fake()
                every { postRepository.save(any()) } returns Unit
            }

            it("returns without crash") {
                updatePostService.update(id, updatePostDto)
            }
        }

        context("when post not found") {
            beforeEach {
                every { postRepository.findById(id) } returns null
            }

            it("returns without crash") {
                shouldThrow<PostNotFoundException> {
                    updatePostService.update(id, updatePostDto)
                }
            }
        }
    }
})