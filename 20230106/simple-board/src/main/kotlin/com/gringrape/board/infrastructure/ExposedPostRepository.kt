package com.gringrape.board.infrastructure

import com.gringrape.board.domain.Post
import com.gringrape.board.domain.PostRepository
import com.gringrape.board.tables.Posts
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.springframework.stereotype.Repository

@Repository
class ExposedPostRepository : PostRepository {
    override fun findAll(): List<Post> {
        return Posts.selectAll().map {
            Post(
                id = it[Posts.id],
                author = it[Posts.author],
                title = it[Posts.title],
                content = it[Posts.content],
                createdAt = it[Posts.created],
            )
        }
    }

    override fun findById(id: Long): Post? {
        return Posts.select { Posts.id eq id }
            .map {
                Post(
                    id = it[Posts.id],
                    author = it[Posts.author],
                    title = it[Posts.title],
                    content = it[Posts.content],
                    createdAt = it[Posts.created],
                )
            }.firstOrNull()
    }

    override fun remove(id: Long) {
        Posts.deleteWhere { Posts.id eq id }
    }

    override fun existById(id: Long): Boolean {
        return !Posts.select { Posts.id eq id }
            .empty()
    }

    override fun save(post: Post) {
        if (post.isNotCreated()) {
            insertPost(post);
            return
        }

        updatePost(post)
    }

    private fun insertPost(post: Post) {
        Posts.insert {
            it[author] = post.author
            it[title] = post.title
            it[content] = post.content
            it[created] = post.createdAt
        }
    }

    private fun updatePost(post: Post) {
        Posts.update({ Posts.id eq post.id }) {
            it[content] = post.content
        }
    }
}
