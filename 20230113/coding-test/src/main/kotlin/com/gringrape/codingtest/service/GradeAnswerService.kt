package com.gringrape.codingtest.service

import com.gringrape.codingtest.domain.Answer
import com.gringrape.codingtest.domain.AnswerRepository
import com.gringrape.codingtest.domain.ProblemRepository
import com.gringrape.codingtest.dtos.AnswerRequest
import org.springframework.stereotype.Service

@Service
class GradeAnswerService(
    val answerRepository: AnswerRepository,
    val problemRepository: ProblemRepository
) {

    fun gradeAnswer(source: AnswerRequest): Answer {
        val answer = Answer.create(source, answerRepository)
        val problem = problemRepository.findById(source.problemId)

        problem.assess(answer)

        return answer
    }

}
