package com.gringrape.board

import com.gringrape.board.domain.Post
import com.gringrape.board.domain.PostRepository
import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.services.FindPostService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class FindPostServiceTest : DescribeSpec({
    lateinit var findPostService: FindPostService

    lateinit var postRepository: PostRepository

    beforeEach {
        postRepository = mockk()
        findPostService = FindPostService(postRepository)
    }

    describe("list") {
        val posts = listOf(Post.fake())

        beforeEach {
            every {
                postRepository.findAll()
            } returns posts
        }

        it("returns posts") {
            findPostService.list() shouldBe posts
        }
    }

    describe("findOne") {
        val id = 1L
        val post = Post.fake()

        context("when post exists") {
            beforeEach {
                every {
                    postRepository.findById(id)
                } returns post
            }

            it("returns post") {
                findPostService.findOne(id) shouldBe post
            }
        }

        context("when post not exist") {
            beforeEach {
                every {
                    postRepository.findById(id)
                } returns null
            }

            it("throws not found exception") {
                shouldThrow<PostNotFoundException> {
                    findPostService.findOne(id)
                }
            }
        }
    }
})