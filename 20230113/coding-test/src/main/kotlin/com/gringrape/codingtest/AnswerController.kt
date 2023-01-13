package com.gringrape.codingtest

import com.gringrape.codingtest.dtos.AnswerDto
import com.gringrape.codingtest.dtos.AnswerRequest
import com.gringrape.codingtest.service.GradeAnswerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("answers")
class AnswerController(
    val gradeAnswerService: GradeAnswerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody source: AnswerRequest): AnswerDto {
        val answer = gradeAnswerService.gradeAnswer(source)
        return AnswerDto(
            id = answer.id,
            submissionResult = answer.submissionResult
        )
    }

}
