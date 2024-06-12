package com.gringrape.shoppingMall.infrastructure

import org.jetbrains.exposed.sql.Table

object Products : Table() {
    val id = long("id").index().autoIncrement()
    val name = varchar("name", 30).index()
    val price = long("price")
    val stockQuantity = integer("stock_quantity")

    override val primaryKey = PrimaryKey(id)
}
