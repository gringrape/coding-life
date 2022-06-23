package com.example.demo.controller

import com.example.demo.application.TaskFinder
import com.example.demo.dto.TaskDto
import com.example.demo.dto.TasksDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(
    var taskFinder : TaskFinder
) {
    @GetMapping
    fun list(): TasksDto {
         return TasksDto(taskFinder.findAll().map {
            TaskDto(
                id= it.id,
                title = it.title
            )
         })
    }
}
