package com.gringrape.codingtest.domain

import com.gringrape.codingtest.dtos.AnswerRequest

class Answer(
    val id: Long
) {
    val submissionResult: String = "PASS"

    fun status(): String {
        return "CORRECT"
    }

    companion object {
        fun create(source: AnswerRequest, answerRepository: AnswerRepository): Answer {
            return Answer(
                id = answerRepository.generateId()
            )
        }
    }
}
