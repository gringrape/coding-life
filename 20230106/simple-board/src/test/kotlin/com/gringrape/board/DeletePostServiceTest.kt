package com.gringrape.board

import com.gringrape.board.domain.PostRepository
import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.services.DeletePostService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk

class DeletePostServiceTest : DescribeSpec({
    lateinit var postRepository: PostRepository
    lateinit var deletePostService: DeletePostService

    beforeEach {
        postRepository = mockk()
        deletePostService = DeletePostService(postRepository)
    }

    describe("delete") {
        val id = 1L

        context("when post found") {
            beforeEach {
                every { postRepository.existById(id) } returns true
                every { postRepository.remove(id) } returns Unit
            }

            it("delete without crash") {
                deletePostService.delete(1L)
            }
        }

        context("when post not found") {
            beforeEach {
                every { postRepository.existById(id) } returns false
            }

            it("throws not found exception") {
                shouldThrow<PostNotFoundException> {
                    deletePostService.delete(id)
                }
            }
        }
    }
})
