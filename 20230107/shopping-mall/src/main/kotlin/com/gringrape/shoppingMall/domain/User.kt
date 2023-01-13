package com.gringrape.shoppingMall.domain

import com.gringrape.shoppingMall.dtos.CreateUserDto
import de.mkammerer.argon2.Argon2Factory

const val INITIAL_ID: Long = 0L

class User(
    id: Long = INITIAL_ID,
    val name: String,
    val email: String,
    val encodedPassword: String
) {
    var id: Long = id
        private set

    fun setId(id: Long) {
        if (this.id != INITIAL_ID) {
            return
        }
        this.id = id
    }

    companion object {
        private val argon2 = Argon2Factory.create()

        fun fake(): User {
            return User(
                id = 1L,
                name = "Jin",
                email = "kingkong@hello.world",
                encodedPassword = ""
            )
        }

        fun create(source: CreateUserDto): User {
            return User(
                name = source.name,
                email = source.email,
                encodedPassword = argon2.hash(10, 65536, 1, source.password.toCharArray())
            )
        }
    }
}
