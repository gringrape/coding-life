package com.gringrape.codingtest

import com.gringrape.codingtest.domain.Answer
import com.gringrape.codingtest.service.GradeAnswerService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import org.hamcrest.core.StringContains.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [AnswerController::class])
class AnswerControllerTests : DescribeSpec() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var gradeAnswerService: GradeAnswerService

    init {
        describe("POST /answers") {
            val answerId = 1L
            val code = "System.out.println(123)"

            beforeEach {
                every {
                    gradeAnswerService.gradeAnswer(any())
                } returns Answer(id = answerId)
            }

            it("responds with answer id") {
                mockMvc.perform(
                    post("/answers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"problemId\":1,\"code\":\"$code\"}")
                )
                    .andExpect(status().isCreated)
                    .andExpect(content().string(containsString("\"id\":$answerId")))
            }
        }
    }

}
