package com.gringrape.shoppingMall.infrastructure

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Orders : Table() {
    val id = long("id").autoIncrement().index()
    val customerId = long("customer_id").index()
    val date = datetime("created_at").index()

    override val primaryKey = PrimaryKey(id)
}
