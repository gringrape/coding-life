package com.example.demo.domain

interface TaskRepository {
    fun findAll() : List<Task>
}
