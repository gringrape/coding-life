package com.gringrape.shoppingMall.infrastructure

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = long("id").index().autoIncrement()
    val name = varchar("name", 20).index()
    val email = varchar("email", 100).index()
    val encodedPassword = text("encoded_password")
//    val address = varchar("address", 100)
//    val phone = varchar("phone", 20).index()

    override val primaryKey = PrimaryKey(id)
}
