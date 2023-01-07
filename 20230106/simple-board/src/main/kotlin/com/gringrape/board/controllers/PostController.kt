package com.gringrape.board.controllers

import com.gringrape.board.dtos.CreatePostDto
import com.gringrape.board.dtos.PostDto
import com.gringrape.board.dtos.PostsDto
import com.gringrape.board.dtos.UpdatePostDto
import com.gringrape.board.exceptions.PostNotFoundException
import com.gringrape.board.services.CreatePostService
import com.gringrape.board.services.DeletePostService
import com.gringrape.board.services.FindPostService
import com.gringrape.board.services.UpdatePostService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("posts")
class PostController(
    val findPostService: FindPostService,
    val createPostService: CreatePostService,
    val deletePostService: DeletePostService,
    val updatePostService: UpdatePostService
) {
    @GetMapping
    fun list(): PostsDto {
        return PostsDto(
            posts = findPostService.list().map {
                PostDto(
                    id = it.id,
                    author = it.author,
                    title = it.title,
                    content = it.content,
                    created = it.createdAt.toString()
                )
            }
        )
    }

    @GetMapping("{id}")
    fun detail(@PathVariable id: Long): PostDto {
        val post = findPostService.findOne(id)
        return PostDto(
            id = id,
            author = post.author,
            title = post.title,
            content = post.content,
            created = post.createdAt.toString()
        )
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody createPostDto: CreatePostDto) {
        createPostService.create(createPostDto)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        deletePostService.delete(id)
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun patch(@PathVariable id: Long, @RequestBody source: UpdatePostDto) {
        updatePostService.update(id, source)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    fun handlePostNotFound(exception: PostNotFoundException): String {
        return "Post does not exist"
    }
}
