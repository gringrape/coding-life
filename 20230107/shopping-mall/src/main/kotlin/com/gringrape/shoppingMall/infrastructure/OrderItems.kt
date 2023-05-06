package com.gringrape.shoppingMall.infrastructure

import org.jetbrains.exposed.sql.Table

object OrderItems : Table() {
    val id = long("id").index().autoIncrement()
    val orderId = long("order_id").index()
    val productId = long("product_id").index()
    val count = integer("count")

    override val primaryKey = PrimaryKey(id)
}
