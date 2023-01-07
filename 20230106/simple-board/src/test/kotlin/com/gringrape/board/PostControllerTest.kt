package com.gringrape.board

import com.gringrape.board.domain.Post
import com.gringrape.board.dtos.UpdatePostDto
import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.services.CreatePostService
import com.gringrape.board.services.DeletePostService
import com.gringrape.board.services.FindPostService
import com.gringrape.board.services.UpdatePostService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.verify
import org.hamcrest.core.StringContains.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class PostControllerTest : DescribeSpec() {
    @MockkBean
    private lateinit var createPostService: CreatePostService

    @MockkBean
    private lateinit var findPostService: FindPostService

    @MockkBean
    private lateinit var deletePostService: DeletePostService

    @MockkBean
    private lateinit var updatePostService: UpdatePostService

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
        describe("GET /posts") {
            beforeEach {
                every {
                    findPostService.list()
                } returns listOf(Post.fake())
            }

            it("responds with posts") {
                mockMvc.perform(get("/posts"))
                    .andExpect(status().isOk)
                    .andExpect(content().string(containsString("{\"id\":")))
            }
        }

        describe("GET /posts/{id}") {
            val post = Post.fake()

            context("when post exist") {
                beforeEach {
                    every { findPostService.findOne(post.id) } returns post
                }

                it("responds with post's detail") {
                    mockMvc.perform(get("/posts/${post.id}"))
                        .andExpect(status().isOk)
                        .andExpect(content().string(containsString("\"id\":${post.id}")))
                }
            }

            context("when post not exist") {
                beforeEach {
                    every { findPostService.findOne(post.id) } throws PostNotFoundException(post.id)
                }

                it("responds with BAD_REQUEST status") {
                    mockMvc.perform(get("/posts/${post.id}"))
                        .andExpect(status().isBadRequest)
                }
            }
        }

        describe("POST /posts") {
            beforeEach {
                every { createPostService.create(any()) } returns Unit
            }

            it("responds with CREATED status") {
                mockMvc.perform(
                    post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"author\":\"Hyunee\",\"title\":\"밥이 맛이 없다\",\"content\":\"그래서?\",\"created\":\"2022-12-03T13:46:55\"}")
                )
                    .andExpect(status().isCreated)

                verify {
                    createPostService.create(any())
                }
            }

            context("with empty fields") {
                it("responds with INVALID status") {
                    mockMvc.perform(
                        post("/posts")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"author\":\"\",\"title\":\"밥이 맛이 없다\",\"content\":\"그래서?\",\"created\":\"2022-12-03T13:46:55\"}")
                    )
                        .andExpect(status().isBadRequest)
                }
            }
        }

        describe("DELETE /posts/{id}") {
            val id = 1L

            context("when post found") {
                beforeEach {
                    every { deletePostService.delete(id) } returns Unit
                }

                it("responds with NO_CONTENT status") {
                    mockMvc.perform(delete("/posts/${id}"))
                        .andExpect(status().isNoContent)
                }
            }

            context("when post not found") {
                beforeEach {
                    every { deletePostService.delete(id) } throws PostNotFoundException(id)
                }

                it("responds with BadRequest status") {
                    mockMvc.perform(delete("/posts/${id}"))
                        .andExpect(status().isBadRequest)
                }
            }
        }

        describe("PATCH /posts/{id}") {
            val id = 1L
            val source = UpdatePostDto(content = "그런데 말입니다")

            context("when post found") {
                beforeEach { every { updatePostService.update(id, source) } returns Unit }

                it("responds with NO_CONTENT status") {
                    mockMvc.perform(
                        patch("/posts/${id}")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"content\":\"${source.content}\"}")
                    )
                        .andExpect(status().isNoContent)
                }
            }

            context("when post not found") {
                beforeEach {
                    every {
                        updatePostService.update(id, source)
                    } throws PostNotFoundException(id)
                }

                it("responds with Bad Request status") {
                    mockMvc.perform(
                        patch("/posts/${id}")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"content\":\"${source.content}\"}")
                    )
                        .andExpect(status().isBadRequest)
                }
            }
        }
    }
}
