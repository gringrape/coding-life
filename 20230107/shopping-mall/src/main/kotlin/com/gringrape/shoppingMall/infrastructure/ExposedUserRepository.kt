package com.gringrape.shoppingMall.infrastructure

import com.gringrape.shoppingMall.domain.User
import com.gringrape.shoppingMall.domain.UserRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Repository

@Repository
class ExposedUserRepository : UserRepository {
    override fun save(user: User) {
        val id = Users.insert {
            it[email] = user.email
            it[name] = user.name
            it[encodedPassword] = user.encodedPassword
        } get Users.id

        user.setId(id)
    }

    override fun findById(userId: Long): User? {
        return Users.select { Users.id eq userId }
            .map {
                User(
                    id = it[Users.id],
                    name = it[Users.name],
                    email = it[Users.email],
                    encodedPassword = it[Users.encodedPassword],
                )
            }.firstOrNull()
    }
}
