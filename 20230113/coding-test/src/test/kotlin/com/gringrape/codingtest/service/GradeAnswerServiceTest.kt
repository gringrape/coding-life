package com.gringrape.codingtest.service

import com.gringrape.codingtest.domain.AnswerRepository
import com.gringrape.codingtest.domain.Problem
import com.gringrape.codingtest.domain.ProblemRepository
import com.gringrape.codingtest.dtos.AnswerRequest
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class GradeAnswerServiceTest : DescribeSpec({

    lateinit var answerRepository: AnswerRepository
    lateinit var problemRepository: ProblemRepository

    lateinit var gradeAnswerService: GradeAnswerService

    beforeEach {
        answerRepository = mockk()
        problemRepository = mockk()

        gradeAnswerService = GradeAnswerService(
            answerRepository = answerRepository,
            problemRepository = problemRepository
        )
    }

    describe("gradeAnswer") {
        val problemId = 1L
        val code = "GOOD CODE"

        val problem = mockk<Problem>()

        beforeEach {
            every { problem.assess(any()) } returns Unit
            every { answerRepository.generateId() } returns 1L
            every { problemRepository.findById(problemId) } returns problem
        }

        it("returns answer with submission result") {
            val answer = gradeAnswerService.gradeAnswer(
                AnswerRequest(
                    problemId = problemId,
                    code = code
                )
            )

            answer.submissionResult shouldBe "PASS"
        }
    }

})
