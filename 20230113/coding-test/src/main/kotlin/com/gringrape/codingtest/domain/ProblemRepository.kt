package com.gringrape.codingtest.domain

interface ProblemRepository {
    fun findById(problemId: Long): Problem
}
