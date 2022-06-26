package com.example.demo.controller

import com.example.demo.application.TaskFinder
import com.example.demo.domain.Task
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import org.hamcrest.Matchers.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TaskController::class)
class TaskControllerTest : DescribeSpec() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var taskFinder: TaskFinder

    init {
        describe("GET /tasks") {
            val tasks = listOf(
                Task(
                    id = 1,
                    title = "hello",
                    isDone = false,
                )
            )

            beforeEach {
                every { taskFinder.findAll() } returns tasks
            }

            it("returns list of tasks") {
                mockMvc.perform(get("/tasks"))
                    .andExpect(status().isOk)
                    .andExpect(content().string(containsString("\"id\":1")))
            }
        }
    }
}
