package com.example.demo.infrastructure

import com.example.demo.domain.Task
import com.example.demo.domain.TaskRepository
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

object Tasks : Table() {
    val id = long("id").autoIncrement()
    val title = varchar("name", length = 50)
}

@Repository
@Transactional
class ExposedTaskRepository : TaskRepository {
    override fun findAll(): List<Task> {
        return Tasks.selectAll().map { row -> Task(
            id = row[Tasks.id],
            title = row[Tasks.title],
            isDone = false,
        ) }
    }
}
