package com.gringrape.codingtest.infrastructure

import com.gringrape.codingtest.domain.Problem
import com.gringrape.codingtest.domain.ProblemRepository
import org.springframework.stereotype.Repository

@Repository
class ExposedProblemRepository : ProblemRepository {
    override fun findById(problemId: Long): Problem {
        TODO("Not yet implemented")
    }
}
