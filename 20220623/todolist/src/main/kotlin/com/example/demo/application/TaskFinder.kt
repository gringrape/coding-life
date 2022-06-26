package com.example.demo.application

import com.example.demo.domain.Task
import com.example.demo.domain.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskFinder(
    private val taskRespository: TaskRepository
) {
    fun findAll(): List<Task> {
        return taskRespository.findAll()
    }
}
