package com.gringrape.board.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

const val INITIAL_ID = 0L

class Post(
    id: Long? = null,
    val author: String,
    val title: String,
    var content: String,
    val createdAt: LocalDateTime,
) {
    fun updateContent(content: String) {
        this.content = content;
    }

    var id: Long = INITIAL_ID
        private set

    init {
        if (id != null) {
            this.id = id
        }
    }

    fun isNotCreated(): Boolean {
        return this.id == INITIAL_ID
    }

    companion object {
        fun fake(): Post {
            return Post(
                author = "Hyunee",
                title = "밥이 맛이 없다",
                content = "그래서?",
                createdAt = "2022-12-03T13:46:55".toLocalDateTime(),
            )
        }
    }
}