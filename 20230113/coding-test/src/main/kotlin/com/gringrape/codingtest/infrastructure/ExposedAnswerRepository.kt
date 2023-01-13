package com.gringrape.codingtest.infrastructure

import com.gringrape.codingtest.domain.AnswerRepository
import org.springframework.stereotype.Repository

@Repository
class ExposedAnswerRepository : AnswerRepository {
    override fun generateId(): Long {
        TODO("Not yet implemented")
    }
}
