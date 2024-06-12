package com.gringrape.shoppingMall.domain

interface UserRepository {
    fun save(user: User)
    fun findById(userId: Long): User?
}
