package com.gringrape.board.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Posts : Table() {
    val id = long("id").index().autoIncrement()
    val author = varchar("author", 50)
    val title = varchar("title", 200)
    val content = text("content")
    val created = datetime("created")

    override val primaryKey = PrimaryKey(id)
}
