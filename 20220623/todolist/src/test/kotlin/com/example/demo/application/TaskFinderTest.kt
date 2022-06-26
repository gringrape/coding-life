package com.example.demo.application

import com.example.demo.domain.Task
import com.example.demo.domain.TaskRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.mockk.every
import io.mockk.mockk

class TaskFinderTest : DescribeSpec() {
    init {
        val task = Task(
            id = 1,
            title = "hello",
            isDone = false,
        )

        describe("list") {
            val taskRespository: TaskRepository = mockk()

            beforeEach {
                every {
                    taskRespository.findAll()
                } returns listOf(task)
            }

            it("returns list of tasks") {
                val taskFinder = TaskFinder(taskRespository)
                taskFinder.findAll() shouldBeEqualToComparingFields listOf(task)
            }
        }
    }
}
